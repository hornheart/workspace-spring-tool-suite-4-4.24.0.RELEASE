<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="itwill" uri="http://www.itwill.co.kr/jsp/simpleTag" %> 
<%
	session.setAttribute("sUserId", "guard");
	request.setAttribute("name", "현빈");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body >
<h1>custom tag[사용자정의태그]</h1><hr/>
---------------hello tag----------------------<br>
<itwill:hello/>
---------------helloAttr tag----------------------<br>
<itwill:helloAttr irum="심경호"/>
<itwill:helloAttr irum="유준열"/>
<itwill:helloAttr irum="${name }"/>
---------------if tag[body]----------------------<br>
<%-- <itwill:if test="${sUserId=null }"/>
	<a href='user'>로그인</a>
</itwill:if> --%>	
<itwill:if test="true">
	반드시 실행<br>
</itwill:if>
<itwill:if test="false">
	실행안함<br>
</itwill:if>

<itwill:if test="${empty sUserId}">
	<a href="user_login_form.jsp">로그인</a>
</itwill:if>
<itwill:if test="${sUserId!=ㅜㅕㅣㅣ}">
	<a href="user_logout_action.jsp">${sUserId}님 로그아웃</a>
</itwill:if>
<img alt="" src="">










</body>
</html>