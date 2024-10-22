package com.itwill.user.controller;



import com.itwill.spring.mvc.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserViewController implements Controller {

	private UserService userService;
	public UserViewController () {
		try {
			
			userService=new UserServiceImpl();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
//		User loginUser=userService.findUser(sUserId);
		String sUserId=(String)session.getAttribute("sUserId");
		if(sUserId==null) {
			return "redirect:user_login_form.do";
		}
		
		try {
			
			User loginUser=userService.findUser(sUserId);
			request.setAttribute("loginUser", loginUser);
			return "forward:/WEB-INF/views/user_view.jsp";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "forward:/WEB-INF/views/user_error.jsp";
		}
//		return "forward:/WEB-INF/views/user_view.jsp";
	}
}
