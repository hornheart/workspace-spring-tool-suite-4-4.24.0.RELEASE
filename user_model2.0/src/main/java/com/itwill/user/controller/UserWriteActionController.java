package com.itwill.user.controller;



import com.itwill.spring.mvc.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserWriteActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		/*
		0  . GET방식요청일때 user_main.jsp로 redirection
		1  . 요청객체 인코딩설정
	    2  . 파라메타 받기
	    3  . UserService객체생성
	    4  . UserService.create() 메쏘드실행
	    5-1. 아이디중복이면 user_write_form.jsp ==> forward
	    5-2. 가입성공이면   user_login_form.jsp 로 redierction
	*/
	String forwardPath="";
		try {
		
			if(request.getMethod().equalsIgnoreCase("GET")){
//				response.sendRedirect("user_main.do");
				forwardPath="redirect:user_main.do";
				return forwardPath;
			}
			
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			User newUser=new User(userId,password,name,email);
			
			UserService userService=new UserServiceImpl();
			int result=userService.create(newUser);
			if(result ==-1){
				/*##############아이디중복##############*/
				String msg=userId+" 는 이미존재하는 아이디입니다.";
				
				/*****************case1 script***********************
				out.println("<script>");
				out.println(" alert('"+msg+"');");
				out.println(" location.href='user_write_form.do';");
				out.println("</script>");
				***************************************************/
				
				/*****************case2 redirect*********************
				response.sendRedirect("user_write_form.jsp");
				****************************************************/
				
				/*****************case3 forward*********************
				forwardPath="forward:/WEB-INF/views/user_write_form.jsp"
				return forwardPath;
				***************************************************/
				request.setAttribute("msg", msg);
				request.setAttribute("fuser", newUser);
				forwardPath="forward:/WEB-INF/views/user_write_form.jsp";
				return forwardPath;
			}else if(result ==1){
				//가입성공==>가입이 끝났기에 리퀘스트도 없애고 전달할 필요가 없다
//				response.sendRedirect("user_login_form.do");
				forwardPath="redirect:user_login_form.do";
				return forwardPath;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/user_error.jsp";
			return forwardPath;
		}
			return "";
//			return "forward:/WEB-INF/views/user_write_action.jsp";
	}//end method
	
}//end clas
