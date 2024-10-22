package com.itwill.spring.mvc;
/*
 * - 모든컨트롤러클래스가 구현해야하는 규칙(interface)
 * - Controller interface를 구현한 클래스의 객체는 DispatcherServlet이 
 *    handleRequest() 메쏘드를호출해서 업무실행
 * - Controller interface 구현한객체는 forwardPath를 반환   
 */

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
	public String handleRequest(HttpServletRequest request,HttpServletResponse response);
}
