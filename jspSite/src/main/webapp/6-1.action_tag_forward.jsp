<%@ page import="com.itwill.address.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println("6-1.action_forward.jsp");
	/* 
		forwarding
			- 6-1.action_tag_forwarded.jsp로 HTTP요청을 보냄
			- request객체에 속성데이타(객체)담기
	*/ 	
	request.setAttribute("id", "guard");
	request.setAttribute("name", "박지은");
	request.setAttribute("age", 20);
	request.setAttribute("address", new Address());
	
	RequestDispatcher rd= request.getRequestDispatcher("6-1.action_tag_forwarded.jsp");
	rd.forward(request, response);
	
%>
 	
 	

 
 
<!--<jsp:forward page="6-1.action_tag_forwarded.jsp"/>  -->
