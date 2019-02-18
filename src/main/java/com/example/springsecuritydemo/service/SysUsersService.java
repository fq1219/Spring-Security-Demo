package com.example.springsecuritydemo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecuritydemo.mapper.SysUsersMapper;
import com.example.springsecuritydemo.entity.SysUsers;

@Service
public class SysUsersService extends ServiceImpl<SysUsersMapper, SysUsers>{

    @Autowired
    public SysUsersMapper usersMapper;

    public SysUsers getUserByUserName(String userName){
        QueryWrapper<SysUsers> userWrapper = new QueryWrapper<>();
        userWrapper.eq("userName", userName);
        return this.getOne(userWrapper);
    }

    public void insert(SysUsers user){
        //密码加密
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        usersMapper.insert(user);
    }

}
