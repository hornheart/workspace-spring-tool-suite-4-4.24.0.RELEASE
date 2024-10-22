package com.itwill.user.controller;



import com.itwill.spring.mvc.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserLogoutActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		/*
   		0  . GET방식요청일때 redirect:user_login_form.do forwardPath반환
   		1  . 파라메타 받기
   		2  . UserService객체생성
   		3  . UserService.login() 메쏘드실행
   			0 : 아이디존재안함  	-> forward:/WEB-INF/views/user_login_form.jsp  forwardPath반환
   			1 : 패쓰워드 불일치		-> forward:/WEB-INF/views/user_login_form.jsp  forwardPath반환
   			2 : 로그인성공(세션)	-> redirect:user_main.do  forwardPath반환
   		*/
		/***************로그인체크[loginCheck.jspf]***********/
		HttpSession session = request.getSession();
		String sUserId=(String)session.getAttribute("sUserId");
		if(sUserId==null) {
			return "redirect:user_login_form.do";
		}
		
		session.invalidate();
		return "redirect:user_main.do";
//		return "forward:/WEB-INF/views/user_logout_action.jsp";
	}
}
