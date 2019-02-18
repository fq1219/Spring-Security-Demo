package com.example.springsecuritydemo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecuritydemo.entity.SysRolesAuthorities;
import com.example.springsecuritydemo.mapper.SysRolesAuthoritiesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRolesAuthoritiesService extends ServiceImpl<SysRolesAuthoritiesMapper, SysRolesAuthorities>{

    @Autowired
    SysRolesAuthoritiesMapper rolesAuthoritiesMapper;

    public List<SysRolesAuthorities> selectByRoleId(String roleId){
        QueryWrapper<SysRolesAuthorities> usersRolesWrapper = new QueryWrapper<>();
        usersRolesWrapper.eq("userId", roleId);
        return rolesAuthoritiesMapper.selectList(usersRolesWrapper);
    }

}
