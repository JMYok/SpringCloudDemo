package com.atguigu.spring.cloud.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.spring.cloud.entity.Employee;
import com.atguigu.spring.cloud.factory.MyFallBackFactory;
import com.atguigu.spring.cloud.util.ResultEntity;

@FeignClient(value = "atguigu-provider",fallbackFactory=MyFallBackFactory.class) //表明当前接口和一个Provider对应，以及与一个降级接口对应
public interface EmployeeRemoteService {
	
	@RequestMapping("/provider/get/employee/remote")
	public Employee getEmployeeRemote();
	
	@RequestMapping("/provider/get/emp/with/circuit/breaker")
	public ResultEntity<Employee> getEmpWithCircuitBreaker(@RequestParam("signal") String signal);
}
