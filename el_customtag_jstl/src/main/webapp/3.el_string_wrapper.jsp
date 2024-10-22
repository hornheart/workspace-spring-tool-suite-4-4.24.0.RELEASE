<%@page import="com.itwill.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("sUserId", "guard[request]");
	session.setAttribute("sUserId", "guard[request]");
	
	session.setAttribute("sUser", new User("guard","1111", "김수근", "sugun@naver.com"));
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL String,Wrapper객체(기본형객체) 출력</h1>
<ol>
	
	<li>${sUserId}</li>
	<li>&dollar;{requestScope.sUserId}-->${requestScope.sUserId}</li>
	<li>&dollar;{sessionScope.sUserId}--> ${sessionScope.sUserId}</li>
	<li style="list-style: none">===========================================</li>
	<li>${sUser}</li>
	<li>${sUser.userId}</li>
	<li>${sUser.password}</li>
	<li>${sUser.name}</li>
	<li>${sUser.email}</li>
	
</ol>
</body>
</html>










