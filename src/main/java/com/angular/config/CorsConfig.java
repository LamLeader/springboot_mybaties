package com.angular.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * Spring Boot + AngularJS 前端AngularJS发送get,post请求实现跨域请求
 * https://blog.csdn.net/xtwu007/article/details/86794672
 * Spring Boot + AngularJS 前端AngularJS发送get,post请求实现跨域请求
 *后端SpringBoot服务设置
 * 新建类CorsConfiguration
 * @author 12484
 *
 */
@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600);
    }
}
