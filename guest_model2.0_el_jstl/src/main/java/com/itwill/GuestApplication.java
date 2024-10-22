package com.itwill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

import com.itwill.spring.mvc.DispatcherServlet;

@SpringBootApplication
@ServletComponentScan(basePackageClasses = DispatcherServlet.class)
public class GuestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuestApplication.class, args);
	}
	
}