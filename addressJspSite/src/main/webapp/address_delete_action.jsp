<%@page import="com.itwill.address.AddressService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	/*
	GET방식으로 요청이 오면 address_main.jsp redirection
	
	* 0.요청객체encoding설정
	* 1.파라메타받기
	* 2.AddressService객체생성
	* 3.AddressService.deleteByNo()메쏘드실행
	* 4.클라이언트로 redirection 응답--> address_list.jsp 로 redirection
	*/
	 if (request.getMethod().equalsIgnoreCase("GET")) {
	     // GET 방식일 때 address_main.jsp로 리다이렉션
	     response.sendRedirect("address_main.jsp");
	     return; // 리다이렉션 후 더 이상 아래 코드를 실행하지 않도록 종료
	 }
	
	try {
		request.setCharacterEncoding("UTF-8");
		String noStr=request.getParameter("no");
		// 'no' 파라미터가 null 또는 비어 있는지 확인
        if (noStr == null || noStr.trim().equals("")) {
            // 파라미터가 없을 경우 리다이렉션
            response.sendRedirect("address_list.jsp");
            return;
        }
		
		AddressService addressService=new AddressService();
		int deleteRowCount=addressService.addressDelete(Integer.parseInt(noStr));
		//삭제 성공 여부에 따라 리다이렉션
        if (deleteRowCount > 0) {
            // 삭제 성공 시 address_list.jsp로 리다이렉션
            response.sendRedirect("address_list.jsp");
        } else {// 삭제 실패 시 에러 페이지 또는 리스트 페이지로 리다이렉션
		response.sendRedirect("address_list.jsp");
        }
	} catch (Exception e) {
		e.printStackTrace();
		response.sendRedirect("address_list.jsp");
	}
%>