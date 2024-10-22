package com.itwill.user.controller;

import com.itwill.spring.mvc.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserRemoveActionController implements Controller {

	private UserService userService;
	public UserRemoveActionController() {
		try {
			userService=new UserServiceImpl();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		HttpSession session=request.getSession();
		String sUserId=(String)session.getAttribute("sUserId");
		/*
		0.login 여부체크
		1.GET방식이면 redirect:user_main.do  forwardPath반환
		2.요청객체인코딩설정
		3.세션에있는 sUserId를 사용해서 UserService.remove(sUserId) 메쏘드호출
		4.성공: redirect:user_main.do  forwardPath반환
		  실패: forward:/WEB-INF/views/user_error.jsp  forwardPath반환
		*/
		if (sUserId == null) {//0.login 여부체크
			// 로그인하지 않았을 경우, 로그인 페이지로 리다이렉트
			forwardPath = "redirect:login_form.do";
			return forwardPath;
		}
		if(request.getMethod().equalsIgnoreCase("GET")) {//1.GET방식이면 redirect:user_main.do  forwardPath반환
			return "redirect:user_main.do";
		}
		try {
			userService.remove(sUserId);
//			int rowCount= request.setAttribute("loginUser", loginUser);
			session.invalidate();
			int rowCount = userService.remove(sUserId);
			return "redirect:user_main.do";
			/*if (rowCount > 0) {
	            forwardPath = "redirect:user_main.do"+rowCount;
	        } else {
	            // 삭제 실패 시 오류 페이지로 포워드
	            forwardPath = "forward:/WEB-INF/views/user_error.jsp";
	        }*/
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "forward:/WEB-INF/views/user_error.jsp";
		}
//		return ;
	}
}
