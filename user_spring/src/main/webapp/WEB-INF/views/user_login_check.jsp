<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//로그인여부체크 =>data를 뽑는 행위는 비지니스가 아니다? 
		//=>흐름제어는 jsp가 하면 안된다? controller 안에서 해결해야 한다?
	//그래서 user_view를 만든다?
	String sUserId = (String)session.getAttribute("sUserId");
	if(sUserId==null){
		response.sendRedirect("user_login_form");
		return;
	}
%>