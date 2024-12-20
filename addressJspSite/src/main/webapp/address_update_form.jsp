<%@page import="oracle.security.o3logon.a"%>
<%@page import="com.itwill.address.Address"%>
<%@page import="com.itwill.address.AddressService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
GET방식요청인경우에는 address_main.jsp로 redirection
 
  0.요청객체인코딩설정 
  1.파라메타받기(no) 
  2.AddressService객체생성 
  3.받은파라메타로 AddressService.selectByNo()메쏘드실행 
  4.반환받은 Address객체를 사용해서 클라이언트로 응답(수정폼 보여주기)
 */
 if (request.getMethod().equalsIgnoreCase("GET")) {
     // GET 방식일 때 address_main.jsp로 리다이렉션
     response.sendRedirect("address_main.jsp");
     return; // 리다이렉션 후 더 이상 아래 코드를 실행하지 않도록 종료
 }
request.setCharacterEncoding("UTF-8");
String noStr=request.getParameter("no");

AddressService addressService=new AddressService();
Address address=addressService.addressDetail(Integer.parseInt(noStr));

 
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>Insert title here</title>
</head>
<body>
<h1>[박경호님 주소록 수정폼]</h1><hr>
<hr>
	<div>
		<a href='address_main.jsp'>[메인]</a>
		<a href='address_insert_form.jsp'>[주소록쓰기폼]</a>
		<a href='address_list.jsp'>[주소록리스트]</a>
	</div>
	<form method='post' action='address_update_action.jsp'>
		번호--- 2 <br>
		<input type='hidden' name='no' value='<%=address.getNo() %>' >
		이름----<input type='text' name='name' value='<%=address.getName()%>'><br>
		전화번호<input type='text' name='phone' value='<%=address.getPhone()%>'><br>
		주소----<input type='text' name='address' value='<%=address.getAddress()%>'><br><br>  
		<input type='submit' value='주소록수정'>
		<input type='reset' value='주소록수정폼지우기'>
	</form>
</body>
</html>
