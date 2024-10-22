package com.itwill.user.controller;



import com.itwill.spring.mvc.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserModifyFormController implements Controller {

	private UserService userService;
	
	public UserModifyFormController() {
		try {
			userService=new UserServiceImpl();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		String forwardPath="";
		HttpSession session=request.getSession();
		String sUserId=(String)session.getAttribute("sUserId");
		if(sUserId==null) {
			return "redirect:user_login_form.do";
		}
  		/*
  		1. UserService객체생성
  		2. 세션의 sUserId를 사용해서 UserService.findUser()메쏘드호출
  		3. 반환된 User객체를 request객체에 setAttribute한다
  		4. forward:/WEB-INF/views/user_modify_form.jsp forwardPath를 반환
  		*/
		try {
			User loginUser=userService.findUser(sUserId);
			request.setAttribute("loginUser", loginUser);
			return "forward:/WEB-INF/views/user_modify_form.jsp";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "forward:/WEB-INF/views/user_error.jsp";
		}
	}
}
