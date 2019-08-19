package com.angular.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * webservice 的接口
 * @author 12484
 *
 */

@WebService
public interface WebServiceDemoService {
     
	@WebMethod
	 public String sayHello(String user);
}
