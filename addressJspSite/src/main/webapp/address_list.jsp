<%@page import="java.util.List"%>
<%@page import="com.itwill.address.Address"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.address.AddressService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
/*
 * 0.요청객체encoding설정
 * 1.파라메타받기
 * 2.AddressService객체생성
 * 3.AddressService객체 addressList() 메쏘드호출
 * 4.List<Address> 리스트 출력
 */
 response.setContentType("text/html;charset=UTF-8");
 String noStr = request.getParameter("no");  // 파라미터 받기
 AddressService addressService = new AddressService();
 List<Address> addressList=addressService.addressList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<h1>[주소록리스트]</h1>
	<hr>
	<div>
		<a href='address_main.jsp'>[메인]</a> <a href='address_insert_form.jsp'>[주소록쓰기폼]</a>
	</div>
	<div>
		<ul>
			<%for(Address address:addressList){ %>
			<!-- address item start -->
			<li><a href='address_detail.jsp?no=<%=address.getNo()%>'>[<%=address.getNo() %>]<%=address.getName() %></a></li>
			<!-- address item end  -->
			<%}%>
		</ul>
	</div>
</body>
</html>
