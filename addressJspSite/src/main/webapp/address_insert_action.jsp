<%@page import="com.itwill.address.AddressService"%>
<%@page import="com.itwill.address.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
 GET방식으로 요청이 오면 address_main.jsp redirection

 * 0.요청객체encoding설정
 * 1.파라메타받기(name,phone,address)--> Address객체생성
 * 2.AddressService객체생성
 * 3.AddressService.insert(Address객체)메쏘드실행
 * 4.address_list.jsp 로 redirection
 */
 
 if (request.getMethod().equalsIgnoreCase("GET")) {
     // GET 방식일 때 address_main.jsp로 리다이렉션
     response.sendRedirect("address_main.jsp");
     return; // 리다이렉션 후 더 이상 아래 코드를 실행하지 않도록 종료
 }
 
 try{
	request.setCharacterEncoding("UTF-8");
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	String addr=request.getParameter("address");
	Address address=new Address(0, name, phone, addr);
	
	AddressService addressService=new AddressService();
	int insertRowCount = addressService.addressWrite(address);
	response.sendRedirect("address_list.jsp");
 }catch(Exception e){
	 e.printStackTrace();
	 response.sendRedirect("address_main.jsp");
 }
 
%>

