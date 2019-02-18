package com.example.springsecuritydemo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecuritydemo.mapper.SysUsersRolesMapper;
import com.example.springsecuritydemo.entity.SysUsersRoles;

@Service
public class SysUsersRolesService extends ServiceImpl<SysUsersRolesMapper, SysUsersRoles>{

    @Autowired
    public SysUsersRolesMapper sysUsersRolesMapper;

    public List<SysUsersRoles> selectByUserId(String userId){
        QueryWrapper<SysUsersRoles> usersRolesWrapper = new QueryWrapper<>();
        usersRolesWrapper.eq("userId", userId);
        return sysUsersRolesMapper.selectList(usersRolesWrapper);

    }


}
