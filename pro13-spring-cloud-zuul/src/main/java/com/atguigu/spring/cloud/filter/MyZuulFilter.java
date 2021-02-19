package com.atguigu.spring.cloud.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class MyZuulFilter extends ZuulFilter {

	Logger logger = LoggerFactory.getLogger(MyZuulFilter.class);
	
	public boolean shouldFilter() {
		// 1.获取当前 RequestContext 对象 
		RequestContext context = RequestContext.getCurrentContext(); 
		// 2.获取当前请求对象 
		HttpServletRequest request = context.getRequest(); 
		// 3.获取当前请求要访问的目标地址 
		String servletPath = request.getServletPath(); 
		// 4.打印 
		System.err.println("servletPath="+servletPath); 
		// 5.当前方法返回值 
		// true：表示应该过滤，下面继续执行 run()方法 
		// false：表示不过滤，直接放行 
		String parameter = request.getParameter("signal");
		return "hello".equals(parameter);
	}

	public Object run() throws ZuulException {
		logger.info("run 方法已执行！");
		return null;
	}

	@Override
	public String filterType() {
		//表示在微服务之前执行
		String filterType = "pre";
		return filterType;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
