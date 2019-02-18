package com.example.springsecuritydemo.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springsecuritydemo.entity.SysAuthoritiesResources;
import com.example.springsecuritydemo.entity.SysResources;
import com.example.springsecuritydemo.service.SysAuthoritiesResourcesService;
import com.example.springsecuritydemo.service.SysAuthoritiesService;
import com.example.springsecuritydemo.service.SysResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Spring Security : 1 加载全部权限 2 根据URL来获取所需权限
 */
@Component
public class RoleFilterInvocationSecurityMetadataSource  implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private SysAuthoritiesService authoritiesService;


    /**
     *  应当是资源为key， 权限为value。 资源通常为url， 权限就是那些以ROLE_为前缀的角色。 一个资源可以由多个权限来访问。
     */
    private Map<String, Collection<ConfigAttribute>> requestMap = new HashMap<>();

    public RoleFilterInvocationSecurityMetadataSource() {
        loadAllAuthority();
    }

    /**
     * 加载全部权限
     * key: url, value: 权限集合
     */
    private void loadAllAuthority() {
        //获取全部权限
        Map<String,String> authoities = authoritiesService.loadAllAuthority();

        //放入requestMap
        for(Map.Entry<String, String> entry : authoities.entrySet()){

            /*
             * 判断资源文件和权限的对应关系，如果已经存在相关的资源url，则要通过该url为key提取出权限集合，将权限增加到权限集合中。
             */
           if(requestMap.containsKey(entry.getKey())){
               ConfigAttribute attribute = new SecurityConfig(entry.getValue());
               requestMap.get(entry.getKey()).add(attribute);
           }else{
               Set<ConfigAttribute> attributes = new HashSet<>();
               ConfigAttribute attribute = new SecurityConfig(entry.getValue());
               attributes.add(attribute);
               requestMap.put(entry.getKey(), attributes);
           }
        }
    }

    /**
     * 此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，
     * 用来判定用户是否有此权限。如果不在权限表中则放行。
     * @param object
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation fi = (FilterInvocation) object;

        for(Map.Entry<String, Collection<ConfigAttribute>> entry : requestMap.entrySet()){
            String uri = entry.getKey();
            RequestMatcher requestMatcher = new AntPathRequestMatcher(uri);
            if (requestMatcher.matches(fi.getHttpRequest())) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
