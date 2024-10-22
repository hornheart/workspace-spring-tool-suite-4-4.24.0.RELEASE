package com.itwill;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.guest.GuestService;

public class SpringApplicationMain {

	public static void main(String[] args) throws Exception{
		/*
		 Spring Container객체생성-ApplicationContext[BeanFactory]객체생성
		 	- Spring Bean 설정파일(SpringApplicationContext.xml)을 읽어서 SpringContainer객체생성
		 */
		System.out.println("------------------spring application context생성시작------------------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill/SpringApplicationContext.xml");
		
		System.out.println("------------------spring application context생성시끝------------------");
	
		GuestService guestService=
				(GuestService)applicationContext.getBean("guestService");
		System.out.println(guestService.guestList());
		System.out.println(guestService.guestDetail(1));
	}

}
