package com.atguigu.spring.cloud.factory;

import org.springframework.stereotype.Component;

import com.atguigu.spring.cloud.api.EmployeeRemoteService;
import com.atguigu.spring.cloud.entity.Employee;
import com.atguigu.spring.cloud.util.ResultEntity;

import feign.hystrix.FallbackFactory;

/**
 * 实现consumer端服务降级功能
 * 实现MyFallBackFactory端口时要传入@FeignClient注解标记的接口类型
 * 当provider调用失败后会执行这个对象对应的方法
 * 必须要有Component注解将其注入到IOC容器中
 * @author dell
 *
 */
@Component
public class MyFallBackFactory implements FallbackFactory<EmployeeRemoteService>{

	public EmployeeRemoteService create(final Throwable cause) {
		return new EmployeeRemoteService() {
			
			public Employee getEmployeeRemote() {
				return null;
			}
			
			public ResultEntity<Employee> getEmpWithCircuitBreaker(String signal) {
				return ResultEntity.failed("降级机制生效 ："+cause.getMessage());
			}
		};
	}

}
