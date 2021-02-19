package com.atguigu.spring.cloud.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.spring.cloud.entity.Employee;
import com.atguigu.spring.cloud.util.ResultEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class EmployeeHandler {

	@RequestMapping("/provider/get/employee/remote")
	public Employee getEmployeeRemote(HttpServletRequest request) {

		// 获取当前 Web 应用的端口号
		int serverPort = request.getServerPort();
		return new Employee(555, "tom555-" + serverPort, 555.55);
	}

	// @HystrixCommand 注解通过 fallbackMethod 属性指定断路情况下要调用的备份方法
	@HystrixCommand(fallbackMethod = "getEmpBackup")
	@RequestMapping("/provider/circuit/breaker/get/emp")
	public ResultEntity<Employee> getEmpWithCircuitBreaker(@RequestParam("signal") String signal) {
		if ("bang".equals(signal)) {
			throw new RuntimeException();
		}
		return ResultEntity.successWithData(new Employee(666, "sam666", 666.66));
	}

	public ResultEntity<Employee> getEmpBackup(@RequestParam("signal") String signal) {
		return ResultEntity.failed("circuit break workded,with signal=" + signal);
	}
}
