<%@page import="com.itwill.guest.GuestService"%>
<%@page import="com.itwill.guest.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String guest_noStr= request.getParameter("guest_no");
if(guest_noStr==null || guest_noStr.equals("")){
	response.sendRedirect("guest_main.jsp");
	return;
}
GuestService guestService=new GuestService();
Guest guest=guestService.guestDetail(Integer.parseInt(guest_noStr));

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>방명록 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/guest.css">

<script src="js/guest.js"></script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->
			
<h1>
	<a href="">WEB SAMPLE SITE</a>
</h1>

			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			
<p>
	<strong>메 뉴</strong>
</p>
<ul>
	<li><a href="guest_main.jsp">방명록홈</a></li>
	<li><a href="guest_list.jsp">방명록리스트</a></li>
	<li><a href="guest_write_form.jsp">방명록쓰기폼</a></li>
</ul>

			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper content start -->
		<div id="wrapper">




			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td>
							<!--contents--> <br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>방명록 관리
											- 방명록 상세보기</b></td>
								</tr>
							</table> <!-- view Form  -->
							<form name="f" method="post">
								<input type="hidden" name="guest_no" value="25" />
								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">번호</td>
										<td width=490 bgcolor="ffffff" align="left"
											style="padding-left: 10px"><%=guest.getGuestNo() %></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
										<td width=490 bgcolor="ffffff" align="left"
											style="padding-left: 10px"><%=guest.getGuestName() %></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">날짜</td>
										<td width=490 bgcolor="ffffff" align="left"
											style="padding-left: 10px"><%=guest.getGuestDate() %></td>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">홈페이지</td>
										<td width=490 bgcolor="ffffff" align="left"
											style="padding-left: 10px"><%=guest.getGuestHomepage() %></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">제목</td>
										<td width=490 bgcolor="ffffff" align="left"
											style="padding-left: 10px"><%=guest.getGuestTitle() %></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="110">내용</td>
										<td width=490 bgcolor="ffffff" align="left"
											style="padding-left: 10px"><%=guest.getGuestContent() %></td>
									</tr>
								</table>
							</form> <br />
							<table width=590 border=0 cellpadding=0 cellspacing=0>
								<tr>
									<td align=center><input type="button" value="수정"
										onClick="guestModifyForm();"> &nbsp; <input type="button"
										value="삭제" onClick="guestRemove();"> &nbsp; <input
										type="button" value="목록" onClick="guestList()"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>


		</div>
		<!-- wrapper content end-->
		<!-- footer start-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			
	<p align="center">Copyright (&copy;) By Kimkyoungho.[김경호] All
		rights reserved.</p>

			<!-- include_common_bottom.jsp end-->
		</div>
		<!-- footer end -->
	</div>
	<!--container end-->
</body>
</html>
