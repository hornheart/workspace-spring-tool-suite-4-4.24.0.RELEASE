
<%@page import="com.itwill.address.Address"%>
<%@page import="com.itwill.address.AddressService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	Date today=new Date();
	ArrayList<String> nameList=new ArrayList<String>();
	nameList.add("KIM");
	
	AddressService addressService=new AddressService();
	Address address=new Address();
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>page 지시어 [import]</h1>
<h2>형태:&lt;%@page import="com.itwill.Student"&gt;</h2>
<hr/>
<%=today %><br>
<%=nameList %><br>
<%=addressService %><br>
<%=address %><br>
</body>
</html>
