package com.example.springsecuritydemo.config;

import com.example.springsecuritydemo.security.FailHandler;
import com.example.springsecuritydemo.security.RoleAccessDecisionManager;
import com.example.springsecuritydemo.security.RoleFilterInvocationSecurityMetadataSource;
import com.example.springsecuritydemo.security.SuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * Spring Security配置类
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RoleAccessDecisionManager roleAccessDecisionManager;

    @Autowired
    private RoleFilterInvocationSecurityMetadataSource roleFilterInvocationSecurityMetadataSource;

    @Autowired
    private FailHandler failHandler;

    @Autowired
    private SuccessHandler successHandler;

    @Override
    public void configure(WebSecurity web) throws Exception {
        //super.configure(web);
        //配置不受secuirty拦截的路径
        web.ignoring()
                .antMatchers("/**/*.scss")
                .antMatchers("/**/*.jpg")
                .antMatchers("/**/*.gif")
                .antMatchers("/**/*.css")
                .antMatchers("/**/*.ico")
                .antMatchers("/**/*.js")
                .antMatchers("/**/*.ttf")
                .antMatchers("/**/*.svg")
                .antMatchers("/**/*.htm")
                .antMatchers("/**/*.html")
                .antMatchers("/**/*.eot")
                .antMatchers("/**/*.woff*")
                .antMatchers("/**/*.less")
                .antMatchers("/**/*.map")
                .antMatchers("/error")
                .antMatchers("/index")
                .antMatchers("/404")
                .antMatchers("/500")
                .antMatchers("/sessionTimeout")
                .antMatchers("/timeout")
                .antMatchers("/html/**")
                .antMatchers("/**/*.png")
                .antMatchers("/")
                .antMatchers("/jquery/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests().
                mvcMatchers("/index.jsp").permitAll().  //首页任何人都可以访问
                anyRequest().authenticated(). //其他的路径均需要认证才能访问
                withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O filterSecurity) {
                        filterSecurity.setAccessDecisionManager(roleAccessDecisionManager);
                        filterSecurity.setSecurityMetadataSource(roleFilterInvocationSecurityMetadataSource);
                        return filterSecurity;
                    }
                }).
                and().
             formLogin() //表单登录
                .loginPage("/jsp/myLogin.jsp") //登录页面
                .loginProcessingUrl("/login") //处理登录的url
                .successHandler(successHandler) //认证成功后的处理
                .failureHandler(failHandler)//认证失败后的处理
                .permitAll() //给登录页面的url，处理登录的url赋予permitAll的ConfigureAttribute，在AccessDecision中将会被放行
                .and()
                //.authenticationProvider(myAuthenticationProvider) //自定义验证的provider
             .logout() //退出登录
                .logoutUrl("/logout") //退出登录的地址
                .logoutSuccessUrl("/jsp/logout.jsp") //退出登录后的跳转地址
                .permitAll();//给退出登录后跳转的地址打上perimitAll的ConfigureAttribute
    }
}
