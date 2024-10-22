package com.itwill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.itwill.spring.mvc.DispatcherServlet;

@SpringBootApplication
@ServletComponentScan
public class UserModelMyBatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserModelMyBatisApplication.class, args);
	
		
	}
	@Bean
	public ServletRegistrationBean fooServletRegistrationBean() {
		ServletRegistrationBean srb=new ServletRegistrationBean(new DispatcherServlet(), "*.do");
		srb.setLoadOnStartup(0);
		return srb;
	}

}
