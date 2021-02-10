package com.atguigu.spring.cloud.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.spring.cloud.api.EmployeeRemoteService;
import com.atguigu.spring.cloud.entity.Employee;

@RestController
public class EmployeeFeignHandler {
	@Autowired
	private EmployeeRemoteService employeeRemoteService;

	@RequestMapping("/feign/consumer/get/emp")
	public Employee getEmployeeRemote() {
		return employeeRemoteService.getEmployeeRemote();
	}
}
