package com.example.springsecuritydemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springsecuritydemo.entity.SysUsers;
import com.example.springsecuritydemo.service.SysUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    public SysUsersService sysUsersService;

    @GetMapping("/{name}")
    public SysUsers getUser(@PathVariable("name") String name){
        QueryWrapper<SysUsers> user = new QueryWrapper<>();
        user.eq("user_name",name);
        return sysUsersService.getOne(user);
    }
}
