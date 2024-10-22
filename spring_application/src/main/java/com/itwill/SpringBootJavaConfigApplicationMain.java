package com.itwill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.order.OrderService;

@SpringBootApplication
@ComponentScan(basePackages = {"com.itwill.order"})
public class SpringBootJavaConfigApplicationMain {
	
	public static void main(String[] args) {
		System.out.println("-----------ApplicationContext생성시작-----------");
		ApplicationContext applicationContex= 
				SpringApplication.run(SpringBootJavaConfigApplicationMain.class, args);
		System.out.println("-----------ApplicationContext끝-----------------");
		OrderService orderService=(OrderService)applicationContex.getBean("orderService");
		System.out.println(orderService.list());
		
	}

}