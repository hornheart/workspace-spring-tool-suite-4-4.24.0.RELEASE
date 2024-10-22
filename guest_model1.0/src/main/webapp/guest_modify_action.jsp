<%@page import="org.apache.catalina.connector.Response"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.itwill.guest.Guest" %>
<%@page import="com.itwill.guest.GuestServiceImpl" %>
    <%
    /*
    */
    //GET방식이면 guest_main.jsp redirection
    if(request.getMethod().equalsIgnoreCase("GET")){
    	response.sendRedirect("guest_main.jsp");
    	return;
    }
    //0.요청객체encoding설정
    request.setCharacterEncoding("UTF-8");
    //1.파라메타받기(guest_no,guest_name,guest_email,guest_homepage,guest_title,guest_content)


    String noStr=request.getParameter("guest_no");
    String name=request.getParameter("guest_name");
    String email=request.getParameter("guest_name");
    String homepage=request.getParameter("guest_homepage");
    String title=request.getParameter("guest_title");
    String content=request.getParameter("guest_content");
    //Guest객체생성
    Guest guest = Guest.builder()
    			.guestNo(Integer.parseInt(noStr))
    			.guestName(name)
    			.guestEmail(email)
    			.guestHomepage(homepage)
    			.guestTitle(title)
    			.guestContent(content)
    			.build();
    //2.GuestService객체생성
    GuestServiceImpl guestService=new GuestServiceImpl(); 
    //3.GuestService객체 updateGuest(Guest객체) 메쏘드호출
    guestService.guestUpdate(guest);
    //4.guest_view.jsp로 redirection
    response.sendRedirect("guest_list.jsp");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>