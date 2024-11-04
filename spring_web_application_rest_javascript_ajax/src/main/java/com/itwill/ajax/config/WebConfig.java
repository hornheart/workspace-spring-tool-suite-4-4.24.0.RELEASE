package com.itwill.ajax.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
//		 	.allowedOrigins("http://192.168.15.31:5500")
//		 	.allowedOrigins("http://127.0.0.1:5500")
		 	.allowedOrigins("http://192.168.15.19:5500","http://localhost:5500","http://127.0.0.1:5500")
		 	.allowedMethods("GET", "POST", "PUT","DELETE")
		 	.allowedHeaders("*")
		 	.maxAge(3600);
	}
}



