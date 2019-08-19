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
public class CorsConfiguration extends WebMvcConfigurerAdapter {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	System.out.println("CorsConfiguration…");
	registry.addMapping("/") //允许跨域访问的链接 "/" 表示允许所有链接
	.allowedMethods(""); //允许的http方法(GET,PUT,POST,DELETE…),"“表示允许所有方法
	}
	
}
