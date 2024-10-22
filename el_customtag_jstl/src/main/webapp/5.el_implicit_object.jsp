<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%
	pageContext.setAttribute("path", "/page.jsp");
	request.setAttribute("path", "/request.jsp");
	session.setAttribute("path", "/session.jsp");
	application.setAttribute("path", "/application.jsp");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL 내장객체(implicit object) 타입은맵이다.</h1><hr>
<ul>
	<li style="list-style: none">---pageScope,requestScope,sessionScope,applicationScope---</li>
		<ul>${path}</ul>
		<ul>${pageScope['path']}</ul>
		<ul>${pageScope.path}</ul>
		<ul>${requestScope.path}</ul>
		<ul>${sessionScope.path}</ul>
		<ul>${applicationScope.path}</ul>
		<li style="list-style: none">================</li> 
		<ul>
			<li>${path}</li>
			<li>${pageScope['path']}</li>
			<li>${pageScope.path }</li>
			<li>${requestScope.path }</li>
			<li>${sessionScope.path }</li>
			<li>${applicationScope.path }</li>
		</ul>
	
	<li>--------param---------</li>
		
		<ul>
				<li>${param}</li>
				<li>${param['id']}</li>
				<li>${param.name}</li>
				<li>${param.hobby}</li>
		</ul>
	
	<li>--------paramValues---------</li>
		
		<ul>
			<li>${paramValues}</li>
			<li>${paramValues.id[0]}</li>
			<li>${paramValues.name[0]}</li>
			<li>${paramValues.hobby[0]}</li>
			<li>${paramValues.hobby[1]}</li>
			<li>${paramValues.hobby[2]}</li>
		</ul>
		
	<li>--------cookie---------</li>
		<ul>
			<li>${cookie['JSESSIONID'].name}</li>
			<li>${cookie['JSESSIONID'].value}</li>
			<li>${cookie.JSESSIONID.name}</li>
			<li>${cookie.JSESSIONID.value}</li>
		</ul>
	<li>--------pageContext[빈객체]---------</li>
	
	<ul>
		
		<li>${pageContext }</li>
		<li>${pageContext.request }</li>
		<li>${pageContext.request.method }</li>
		<li>${pageContext.request.getRequestURI()}</li>
		<li>${pageContext.request.requestURI}</li>
		<li>${pageContext.session}</li>
		<li>${pageContext.servletContext}</li>
		<li>${pageContext.response}</li>
	</<ul>
  <li> Item one </li>
  <li> Item two </li>
</ul>

</ul>	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</ul>
</body>
</html>