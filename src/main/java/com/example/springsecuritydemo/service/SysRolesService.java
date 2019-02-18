package com.example.springsecuritydemo.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecuritydemo.mapper.SysRolesMapper;
import com.example.springsecuritydemo.entity.SysRoles;

@Service
public class SysRolesService extends ServiceImpl<SysRolesMapper, SysRoles>{

}
