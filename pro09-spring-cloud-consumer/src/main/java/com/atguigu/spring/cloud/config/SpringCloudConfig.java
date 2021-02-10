package com.atguigu.spring.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringCloudConfig {
	@Bean
	@LoadBalanced //负载均衡功能,通过调用Ribbon访问Provider集群
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
