package com.itwill.spring.mvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * 모든 controller들이 준수해야 할 규칙 interface
 *  - Controller interface를 구현한 클래스의 객체는 DispatcherServlet이 
 *    handleRequest() 메쏘드를호출해서 업무실행
 * - Controller interface 구현한객체는 forwardPath를 반환   
 * */
public interface Controller {
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response);
	
}
