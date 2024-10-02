<%@page import="java.net.URLEncoder"%>
<%@page import="com.itwill.shop.user.exception.ExistedUserException"%>
<%@page import="com.itwill.shop.user.UserService"%>
<%@page import="com.itwill.shop.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if(request.getMethod().equalsIgnoreCase("GET")){
	out.println("GET앙되요");
	return;
}
String userId = request.getParameter("userId");
String password = request.getParameter("password");
String name = request.getParameter("name");
String email = request.getParameter("email");

User newUser = new User(userId, password, name, email);
UserService userService = new UserService();
int rowCount = userService.create(newUser);
%>
insert rowCount : <%=rowCount %>
















