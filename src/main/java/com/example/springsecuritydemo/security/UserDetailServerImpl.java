package com.example.springsecuritydemo.security;

import com.example.springsecuritydemo.entity.SysAuthorities;
import com.example.springsecuritydemo.entity.SysUsers;
import com.example.springsecuritydemo.service.SysAuthoritiesService;
import com.example.springsecuritydemo.service.SysUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Spring Security 的获取用户信息的实现类
 */
@Service
public class UserDetailServerImpl implements UserDetailsService {

    @Autowired
    public SysUsersService usersService;

    @Autowired
    public SysAuthoritiesService authoritiesService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUsers user = usersService.getUserByUserName(username);

        //获取本人权限
        List<SysAuthorities> authorities = authoritiesService.selectSysByUserId(user.getUserId());
        Set<RoleGrantedAuthority> grantedAuthorities = new HashSet<>();
        authorities.forEach(x-> grantedAuthorities.add(new RoleGrantedAuthority(x.getAuthorityName())));

        UserDetail userDetail = new UserDetail(user.getUserPassword(), username,  grantedAuthorities);

        return userDetail;
    }
}
