package com.itwill1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestService;
import com.itwill.product.ProductDao;
import com.itwill.product.ProductService;
/*
@SpringBootApplication
  - 현재클래스가위치하는 패키지와 하위패키지 클래스의 
    @Annotation을 스캔해서초기화(객체생성,의존성주입)
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.itwill.product"})
public class SpringBeanCreateApplicationMain {

	public static void main(String[] args) {
		System.out.println("----------Spring Container초기화시작[ApplicationContext객체생성시작]-----------------");
		ApplicationContext applicationContext= 
				SpringApplication.run(SpringBeanCreateApplicationMain.class, args);
		System.out.println("----------Spring Container초기화시작[ApplicationContext객체생성끝]-----------------");
		System.out.println("");
		System.out.println("-----------스프링컨테이너에 등록된 빈클래스로 스프링빈 객체참조얻기-----------");
		ProductDao productDao1= applicationContext.getBean(ProductDao.class);
		ProductService productService1= applicationContext.getBean(ProductService.class);
		System.out.println(productDao1);
		System.out.println(productService1);
		System.out.println("-------스프링컨테이너에 등록된  빈아이디로 스프링빈 객체참조얻기--------");
		ProductDao productDao2=(ProductDao)applicationContext.getBean("productDao");
		ProductService productService2=(ProductService)applicationContext.getBean("productService");
		System.out.println(productDao2);
		System.out.println(productService2);
		System.out.println("----빈의 @Scope(singleton)---");
		System.out.println(applicationContext.getBean(ProductDao.class));
		System.out.println(applicationContext.getBean(ProductDao.class));
		System.out.println(applicationContext.getBean(ProductService.class));
		System.out.println(applicationContext.getBean(ProductService.class));
	
	}
}