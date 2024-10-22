<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>	
<%@
	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%>    	
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 	
<p>
	<strong><fmt:message key="page.menu"/></strong>
</p>
<ul>
	<%-- <%if(sUserId!=null){ %>
		<!-- 로그인후 -->
		<li><a href=""><%=sUserId %> 님</a></li>
		<li><a href="user_view.do">내정보</a></li>
		<li><a href="user_logout_action.do">로그아웃</a></li>
	<%}else{ %>
		<!-- 로그인전 -->
		<li><a href="user_login_form.do">로그인</a></li>
		<li><a href="user_write_form.do">회원가입</a></li>
 	<%} %> --%>
 	<c:choose>
 		<c:when test="${sUserId != null}">
 			<!-- 로그인후 -->
			<li><a href="">${sUserId} 님</a></li>
			<li><a href="user_view.do">내정보</a></li>
			<li><a href="user_logout_action.do">로그아웃</a></li>
 		</c:when>
 		<c:otherwise>
			<!-- 로그인전 -->
			<li><a href="user_login_form.do"><fmt:message key="page.menu.login"></fmt:message></a></li>
			<li><a href="user_write_form.do"><fmt:message key="page.menu.join"/></a></li>
		</c:otherwise>
 	</c:choose>
 	
</ul>