<%@page import="com.itwill.guest.GuestServiceImpl"%>
<%@page import="com.itwill.guest.Guest" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
 */
//GET방식이면 guest_main.jsp redirection
 if(request.getMethod().equalsIgnoreCase("GET")){
	 response.sendRedirect("guest_main.jsp");
	 return;
 }
String noStr=request.getParameter("no");
//0.요청객체encoding설정
request.setCharacterEncoding("UTF-8");
//1.파라메타받기(guest_no)
String guest_noStr=request.getParameter("guest_no");
int guest_no = Integer.parseInt(guest_noStr);
//2.GuestService객체생성
GuestServiceImpl guestService=new GuestServiceImpl();
//3.GuestService객체 deleteGuest(guest_no) 메쏘드호출
guestService.guestDelete(guest_no);
//4.guest_list.jsp로 redirection
response.sendRedirect("guest_list.jsp?no="+noStr);
%>