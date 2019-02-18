package com.example.springsecuritydemo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springsecuritydemo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecuritydemo.mapper.SysAuthoritiesMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Service
public class SysAuthoritiesService extends ServiceImpl<SysAuthoritiesMapper, SysAuthorities>{

    @Autowired
    private SysResourcesService resourcesService;

    @Autowired
    private SysAuthoritiesResourcesService authoritiesResourcesService;

    @Autowired
    private SysUsersRolesService usersRolesService;

    @Autowired
    private SysRolesAuthoritiesService rolesAuthoritiesService;

    @Autowired
    private SysAuthoritiesMapper authoritiesMapper;

    public Map<String, String> loadAllAuthority() {
        Map<String, String> result = new HashMap<>();
        //获取所有资源
        List<SysResources> resources = resourcesService.list();
        resources.forEach(x-> {
           authoritiesResourcesService.selectByResourceId(x.getResourceId())
                   .forEach(y -> {
                        SysAuthorities authoritie = authoritiesMapper.selectById(y.getAuthorityId());
                        result.put(x.getResourceString(), authoritie.getAuthorityName());
                    });
        });
        return result;
    }

    public List<SysAuthorities> selectSysByUserId(String userId){
        List<SysAuthorities> result = new ArrayList<>();
        List<SysUsersRoles> usersRoles = usersRolesService.selectByUserId(userId);
        usersRoles.forEach(x->
            rolesAuthoritiesService.selectByRoleId(x.getRoleId()).forEach(y-> result.add(authoritiesMapper.selectById(y.getAuthorityId())))
        );
        return result;
    }


}
