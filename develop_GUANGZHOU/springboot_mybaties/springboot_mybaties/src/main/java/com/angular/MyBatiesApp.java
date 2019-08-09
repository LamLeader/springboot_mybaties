package com.angular;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 1.mybatis启动方式可以在mapper层不需要加mapper注解。但是一定要在启动类的时候加上@MapperScan<br>
 * 2.myabtis在mybatis接口加上@Mapper注入myabtis容器，就不需要在启动类的时候加上@MapperScan 
 * 3.springboot 2.0 之后 sprin5.0<br>
 * <br>
 * 
 */
@SpringBootApplication
@MapperScan(basePackages={"com.angular.dao"})
public class MyBatiesApp {
	
    public static void main(String[] args) {
    	
		SpringApplication.run(MyBatiesApp.class, args);
	}
}
