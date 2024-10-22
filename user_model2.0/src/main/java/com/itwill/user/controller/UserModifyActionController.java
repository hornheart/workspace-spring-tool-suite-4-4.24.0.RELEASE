package com.itwill.user.controller;

import com.itwill.spring.mvc.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserModifyActionController implements Controller {

	private UserService userService;
	
	public UserModifyActionController() {
		try {
			userService = new UserServiceImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	String forwardPath = "";
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		// 0. 로그인 여부 체크
        String sUserId = (String) request.getSession().getAttribute("sUserId");
        if (sUserId == null) {
            // 로그인하지 않았을 경우, main 리다이렉트
            forwardPath = "redirect:user_main.do";
            return forwardPath;
        }
		/*
		0.login 여부체크
		1.GET방식이면 redirect:user_main.do forwardPath반환
		2.요청객체인코딩설정
		3.파라메타받기(password,name,email)
		4.세션의 sUserId와 파라메타(password,name,email) 로 User객체생성후  UserService.update 메쏘드호출
		5.성공: redirect:user_view.do forwardPath반환
		  실패: forward:/WEB-INF/views/user_error.jsp  forwardPath반환
		*/
		try {
			if(request.getMethod().equalsIgnoreCase("GET")) {
				forwardPath="redirect:user_main.do";
			}else {
				String name=request.getParameter("name");
				String password=request.getParameter("password");
				String password2=request.getParameter("password2");
				String email=request.getParameter("email");
				if (!password.equals(password2)) {
				    request.setAttribute("error", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
				    return "forward:/WEB-INF/views/user_modify_form.jsp";
				}
//				UserService userService=new UserServiceImpl();
				int rowCount=userService.update(User.builder()
													.userId(sUserId)
													.name(name)
													.password(password)
													.email(email)
													.build());
				forwardPath="redirect:user_view.do";
			}
			return "redirect:user_view.do";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/user_error.jsp";
			// TODO: handle exception
		}
		
//		return "forward:/WEB-INF/views/user_modify_action.jsp";
		return forwardPath;
	}
}
