<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.itwill.guest.Guest" %>
<%@page import="com.itwill.guest.GuestService" %>
<%
/*
	GET방식이면 guest_main.jsp redirection

  0.요청객체encoding설정
  1.파라메타받기(guest_name,guest_email,guest_homepage,guest_title,guest_content)
     Guest객체생성
  2.GuestService객체생성
  3.GuestService객체 insertGuest(Guest객체) 메쏘드호출
  4.guest_list.jsp로 redirection
 */
 if (request.getMethod().equalsIgnoreCase("GET")) {
     // GET 방식일 때 address_main.jsp로 리다이렉션
     response.sendRedirect("guest_main.jsp");
     return; // 리다이렉션 후 더 이상 아래 코드를 실행하지 않도록 종료
 }

try{
	request.setCharacterEncoding("UTF-8");
	String name=request.getParameter("guest_name");
	String email=request.getParameter("guest_email");
	String homepage=request.getParameter("guest_homepage");
	String title=request.getParameter("guest_title");
	String content=request.getParameter("guest_content");
	GuestService guestService=new GuestService();
	Guest guest= Guest.builder()
								
								.guestName(name)
								.guestEmail(email)
								.guestHomepage(homepage)
								.guestTitle(title)
								.guestContent(content)
								
								.build();
	
//	int insertRowCount = guestService.guestWrite(guest);
	response.sendRedirect("address_list.jsp");
}catch(Exception e){
	 e.printStackTrace();
	 response.sendRedirect("address_main.jsp");
}

%>