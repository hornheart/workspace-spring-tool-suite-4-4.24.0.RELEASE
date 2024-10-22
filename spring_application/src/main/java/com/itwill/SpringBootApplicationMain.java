package com.itwill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.guest.GuestService;
/*
 @SpringBootApplication
 	- 현재 클래스가 위치하는 패키지와 하위패키지 클래스의 @Annotation을 스캔해서 초기화 (객체생성, 의존성주입)
 
 * */
@SpringBootApplication
@ComponentScan(basePackages = {"com.itwill.guest"})
public class SpringBootApplicationMain {
	
	public static void main(String[] args) throws Exception{
		
		System.out.println("-------------Sprint boot applicationContext 생성시작-------------");
		
		ApplicationContext applicationContext=
			SpringApplication.run(SpringBootApplicationMain.class, args);
			
		System.out.println("-------------Sprint boot applicationContext 객체 생성 시작-------------");
		//GuestService guestService=(GuestService)applicationContext.getBean("guestService");==>지양
		GuestService guestService=(GuestService)applicationContext.getBean(GuestService.class);
		System.out.println(guestService.guestList());
		System.out.println(guestService.guestDetail(1));
		
	}

}
