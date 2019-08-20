package com.angular.service;

import java.util.Date;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

/*@Service
@WebService(serviceName="WebServiceDemoService",//接口名称
		targetNamespace="com.angular.service",//与接口中的命名空间一致，一般是接口的包名
		endpointInterface="com.angular.service.WebServiceDemoService" //接口地址
)*/
public class WebServiceDemoServiceImpl implements WebServiceDemoService{

	@Override
    public String sayHello(String user) {
        return user+":hello"+"("+new Date()+")";
    }
    
}
