<%@page import="com.itwill.user.User"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	errorPage="user_error.jsp"
	
	%>
<%@ include file="user_login_check.jspf"%>

<%

	/*
		0.login 여부체크
		1.GET방식이면 user_main.jsp redirection
		2.요청객체인코딩설정
		3.파라메타받기(userId,password,name,email)
		4.받은파라메타(userId,password,name,email) 로 User객체생성후  UserService.update 메쏘드호출
		5.성공:user_view.jsp redirection
		  실패:user_error.jsp 
	*/
	if (request.getMethod().equalsIgnoreCase("GET")) {
		response.sendRedirect("user_main.jsp");
		return;
	}
	String userId = request.getParameter("userId");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	int rowCount = new UserService().update(new User(userId, password, name, email));
	response.sendRedirect("user_view.jsp");

%>