package com.example.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * mvc配置类
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    //配置mvc视图解析器
   /* @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }*/

    //配置静态资源映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addResourceHandler("/**") 表示暴露对外访问的路径
        //addResourceLocations("/") 表示静态资源文件存储的路径
        registry.addResourceHandler("/**").addResourceLocations("/");
    }

    //配置mvc视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        registry.viewResolver(viewResolver);
    }
}
