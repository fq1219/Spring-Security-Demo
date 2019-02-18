package com.example.springsecuritydemo.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Spring Security 的 GrantedAuthority，用户的授权角色，以ROLE_开头，如ROLE_ADMIN,ROLE_USER
 */
public class RoleGrantedAuthority implements GrantedAuthority {

    private String authority;

    public RoleGrantedAuthority(String role) {
        this.authority = authority;
    }


    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
