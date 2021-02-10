package com.atguigu.spring.cloud.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.cloud.entity.Employee;

@RestController
public class HumanResourceHandler {
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/consumer/ribbon/get/employee")
	public Employee getEmployeeRemote() {

		// 远程调用方法的主机地址
		//String host = "http://localhost:1000";
		//引入Eureka和Ribbon后，就可以使用微服务名称替代IP地址+端口号
		String host = "http://atguigu-provider";	

		// 远程调用方法的具体 URL 地址 ,以及返回类型
		String url = "/provider/get/employee/remote";
		return restTemplate.getForObject(host + url, Employee.class);
	}
}
