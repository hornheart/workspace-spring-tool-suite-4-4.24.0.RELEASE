package com.itwill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApplicationDaoApplication {

	public static void main(String[] args) {
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		SpringApplication.run(SpringApplicationDaoApplication.class, args);
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
	}

}
