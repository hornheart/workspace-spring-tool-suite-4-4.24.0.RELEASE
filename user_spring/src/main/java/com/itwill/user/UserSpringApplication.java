package com.itwill.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.itwill.user"})
public class UserSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserSpringApplication.class, args);
	}

}
