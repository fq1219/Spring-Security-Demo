package com.example.springsecuritydemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(value="com.example.springsecuritydemo.mapper")
@EnableTransactionManagement(proxyTargetClass=true)
//@EnableAspectJAutoProxy(proxyTargetClass=true, exposeProxy = true)
public class SpringSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoApplication.class, args);
    }

}

