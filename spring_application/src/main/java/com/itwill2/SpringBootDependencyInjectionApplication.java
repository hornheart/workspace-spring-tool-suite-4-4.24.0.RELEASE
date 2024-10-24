package com.itwill2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.user.UserService;

@SpringBootApplication
@ComponentScan(basePackages = {"com.itwill.user"})
public class SpringBootDependencyInjectionApplication {

	public static void main(String[] args) throws Exception {
		System.out.println("----------Spring Container초기화시작[ApplicationContext객체생성시작]-----------------");
		ApplicationContext applicationContext =
				SpringApplication.run(SpringBootDependencyInjectionApplication.class, args);
		System.out.println("----------Spring Container초기화시작[ApplicationContext객체생성끝]-----------------");
		UserService userService = 
				(UserService)applicationContext.getBean(UserService.class);
		System.out.println(userService.findUserList());
		System.out.println(userService.findUser("guard1"));
	
	}
}
