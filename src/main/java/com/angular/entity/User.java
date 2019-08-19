package com.angular.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class User {
    
	private int id;
	private Integer age;
	private String name;
	private String psw;
	private String createDate;
	 
	/**
	 * 测试 get set
	 * @param args
	 */
	public static void main(String[] args) {
		User user=new User();
		
	}
}
