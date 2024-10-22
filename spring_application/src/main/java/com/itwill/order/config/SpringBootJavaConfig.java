package com.itwill.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.itwill.order.OrderDao;
import com.itwill.order.OrderDaoImpl;
import com.itwill.order.OrderService;
import com.itwill.order.OrderServiceImpl;

@Configuration
public class SpringBootJavaConfig {
	@Bean
	public OrderDao orderDao() {
		return new OrderDaoImpl();
	}
	@Bean
	public OrderService orderService() {
		OrderServiceImpl orderService=new OrderServiceImpl();
		orderService.setOrderDao(this.orderDao());
		return orderService;
	}
	
}