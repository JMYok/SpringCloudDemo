package com.atguigu.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//启用 Eureka 服务器功能 
@EnableEurekaServer
@SpringBootApplication
public class SpringBootStarter {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStarter.class, args);
	}

}
