package com.atguigu.spring.cloud.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.spring.cloud.entity.Employee;

@FeignClient("atguigu-provider") //表明当前接口和一个Provider对应
public interface EmployeeRemoteService {
	
	@RequestMapping("/provider/get/employee/remote")
	public Employee getEmployeeRemote();
}
