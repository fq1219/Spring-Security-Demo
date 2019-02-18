package com.example.springsecuritydemo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecuritydemo.entity.SysAuthoritiesResources;
import com.example.springsecuritydemo.mapper.SysAuthoritiesResourcesMapper;

@Service
public class SysAuthoritiesResourcesService extends ServiceImpl<SysAuthoritiesResourcesMapper, SysAuthoritiesResources>{

    @Autowired
    SysAuthoritiesResourcesMapper authoritiesResourcesMapper;

    public List<SysAuthoritiesResources> selectByResourceId(String resourceId){
        QueryWrapper<SysAuthoritiesResources> queryWrapper = new  QueryWrapper<SysAuthoritiesResources>();
        queryWrapper.eq("resourceId", resourceId );
        return authoritiesResourcesMapper.selectList(queryWrapper);
    }
}
