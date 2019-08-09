package com.angular.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author: MaoJiaBin
 * @date: 2018/7/16
 * @description: 该类用来配置Spring Boot，是Java代码配置的方式
 */
@SuppressWarnings("deprecation")
@Configuration
public class ApplicationConfig extends WebMvcConfigurerAdapter {


	/**
	 * Java配置的拦截器--把拦截器纳入spring 容器管理，可以使用 @Value("${cors.Access-Control-Allow-Origin}") 注入配置文件
	 * @return
	 */
	@Bean
	public AxiosOptionsInterceptor axiosOptionsInterceptor() {
		return new AxiosOptionsInterceptor();
	}

	/**
	 * 跨域资源共享问题，用来应对Vue + axios 的OPTIONS 请求
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(axiosOptionsInterceptor()).addPathPatterns("/**");
//		registry.addInterceptor(securityInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}

	@Bean
	public MultipartConfigElement multipartConfigElement(){
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//文件最大KB,MB
		factory.setMaxFileSize("6MB");
		//设置总上传数据总大小
//		factory.setLocation("/var/temp");
		factory.setMaxRequestSize("20MB");
		return factory.createMultipartConfig();
	}
}
