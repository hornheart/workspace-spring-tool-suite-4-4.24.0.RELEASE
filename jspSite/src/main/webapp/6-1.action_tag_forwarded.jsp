<%@page import="com.itwill.address.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println("6-1.action_tag_forwarded.jsp");
	/*
		- 6-1.action_tag_forwarded.jsp (forwarding한 HTTP요정에 의해 실행)
		- request객체로 부터 속성데이타(객체)를 꺼낸다.
	*/
	String id=(String)request.getAttribute("id");
	String name=(String) request.getAttribute("name");
	int age=(Integer) request.getAttribute("age");
	Address address=(Address) request.getAttribute("address");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>6-1.action_tag_forwarded.jsp</h1>
<hr>
<p>
	나는 6-1.action_tag_forward.jsp에서 forwading
	당한 jsp입니다..
	제가 응답합니다.
</p>
<p>
	6-1.action_tag_forward.jsp에서 request에 담은 속성객체<br>
	<%=id %><br> 
	<%=name %><br> 
	<%=age %><br> 
	<%=address %><br> 
</p>
</body>
</html>
