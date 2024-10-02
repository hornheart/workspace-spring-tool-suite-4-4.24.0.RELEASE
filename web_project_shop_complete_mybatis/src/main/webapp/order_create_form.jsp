<%@page import="org.eclipse.jdt.internal.compiler.env.IBinaryNestedType"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="com.itwill.shop.order.Order"%>
<%@page import="com.itwill.shop.order.OrderItem"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.itwill.shop.product.Product"%>
<%@page import="com.itwill.shop.product.ProductService"%>
<%@page import="com.itwill.shop.user.UserService"%>
<%@page import="com.itwill.shop.cart.CartService"%>
<%@page import="com.itwill.shop.cart.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf"%>
<%
if (request.getMethod().equalsIgnoreCase("GET")) {
	response.sendRedirect("product_list.jsp");
	return;
}
String buyType = request.getParameter("buyType");
if (buyType == null){
	response.sendRedirect("product_list.jsp");
	return;
}

CartService cartService = new CartService();
UserService userService = new UserService();
ProductService productService = new ProductService();

int tot_price = 0;
int oi_tot_count = 0;
String[] cart_noStr_array = new String[]{};
Order order = new Order();
User loginUser=userService.findUser(sUserId);

if (buyType.equals("cart")) {
	/*
	카트테이블에있는 모든제품을 주문하기
	*/
	List<Cart> cartItemList = new ArrayList<Cart>();
	cartItemList = cartService.getCartItemByUserId(sUserId);
	for (Cart cart : cartItemList) {
		order.getOrderItemList().add(new OrderItem(0, cart.getCart_qty(), 0, cart.getProduct()));
		tot_price += cart.getCart_qty() * cart.getProduct().getP_price();
		oi_tot_count += cart.getCart_qty();
	}
} else if (buyType.equals("cart_select")) {
	/*
	카트보기에서 선택된 제품을 주문하기
	*/
	cart_noStr_array = request.getParameterValues("cart_no");
	if(cart_noStr_array==null){
		response.sendRedirect("product_list.jsp");
		return;
	}

	for (String cart_noStr : cart_noStr_array) {
		int cart_no=Integer.parseInt(cart_noStr);
		Cart cart=cartService.getCartItemByCartNo(cart_no);
		Product product=cart.getProduct();
		
		order.getOrderItemList().add(new OrderItem(0, cart.getCart_qty(), 0, product));
		tot_price += cart.getCart_qty() * product.getP_price();
		oi_tot_count += cart.getCart_qty();
		
	}

} else if (buyType.equals("direct")) {
	/*
	상품에서에서 직접제품을 주문하기
	*/
	String p_noStr = request.getParameter("p_no");
	String p_qtyStr = request.getParameter("p_qty");
	if (p_noStr == null || p_qtyStr == null){
		response.sendRedirect("product_list.jsp");
		return;
	}
	
	Product product = productService.productDetail(Integer.parseInt(p_noStr));
	order.getOrderItemList().add(new OrderItem(0, Integer.parseInt(p_qtyStr), 0, product));
	tot_price = order.getOrderItemList().get(0).getOi_qty() * order.getOrderItemList().get(0).getProduct().getP_price();
	oi_tot_count += order.getOrderItemList().get(0).getOi_qty();

}

String o_desc = order.getOrderItemList().get(0).getProduct().getP_name() + "외 " + (oi_tot_count - 1) + " 개";
order.setUserid(sUserId);
order.setO_price(tot_price);
order.setO_desc(o_desc);


/**********************세션에 주문데이타담기***************************/
session.setAttribute("order", order);
/*********************************************************************/
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>쇼핑몰 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
<style type="text/css" media="screen">
/*
form > table tr td{
	border: 0.1px solid black;
}
*/
</style>
<script type="text/javascript">
	/*
	 * 주문
	 */
	function order_create_form_submit() {
		if(document.order_create_form.address.value==''){
			alert("배송지를 입력해주세요");
			document.order_create_form.address.focus();
			return;
		}
		document.order_create_form.method = 'POST';
		document.order_create_form.action = 'order_create_action.jsp';
		document.order_create_form.submit();
	}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->
			<jsp:include page="include_common_top.jsp" />
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="include_common_left.jsp" />
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->

			<!-- include_content.jsp start-->
			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td><br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>쇼핑몰 -
											주문/결제폼</b></td>
								</tr>
							</table> 
							<!--form-->
							<form  name="order_create_form">
								<input type="hidden" name="buyType" value="<%=buyType%>">
								<%for(String cart_no:cart_noStr_array){ %>
									<input type="hidden" name="cart_no" value="<%=cart_no%>">
								<% }%>
								<table align=center width=80% border="0" cellpadding="0"
									cellspacing="1" bgcolor="BBBBBB">
									<caption style="text-align: left;">배송지정보</caption>
									<tr>
										<td width=112 height=26 align=left bgcolor="ffffff" class=t1>&nbsp;&nbsp;받으실 분</td>
										<td width=456 height=26 align=left bgcolor="ffffff" class=t1><%=loginUser.getName()%></td>
										<td width=50 height=26 align=center bgcolor="ffffff" class=t1></td>
									</tr>
									<tr>
										<td width=112 height=26 align=left bgcolor="ffffff" class=t1>&nbsp;&nbsp;주소</td>
										<td width=456 height=26 align=left bgcolor="ffffff" class=t1><input type="text" name="address" style="width:300px;margin-left:5px"></td>
										<td width=50 height=26 align=center bgcolor="ffffff" class=t1></td>
									</tr>
								</table>
								<br />

								<table align=center width=80% border="0" cellpadding="0"
									cellspacing="1" bgcolor="BBBBBB">
									<caption style="text-align: left;">주문제품목록</caption>
									<tr style="border: 0.1px solid">
										<td width=290 height=25 bgcolor="E6ECDE" align=center class=t1>강아지
											이름</td>
										<td width=112 height=25 bgcolor="E6ECDE" align=center class=t1>수
											량</td>
										<td width=166 height=25 bgcolor="E6ECDE" align=center class=t1>가
											격</td>
										<td width=50 height=25 bgcolor="E6ECDE" align=center class=t1>비
											고</td>
									</tr>
									<%
									for (OrderItem orderItem : order.getOrderItemList()) {
									%>
									<!-- order item start -->
									<tr>
										<td width=290 height=26 align=center bgcolor="ffffff" class=t1>
											<a
											href='product_detail.jsp?p_no=<%=orderItem.getProduct().getP_no()%>'><%=orderItem.getProduct().getP_name()%></a>
										</td>
										<td width=112 height=26 align=center bgcolor="ffffff" class=t1><%=orderItem.getOi_qty()%></td>
										<td width=166 height=26 align=center bgcolor="ffffff" class=t1>
											<%=new DecimalFormat("#,###").format(orderItem.getOi_qty() * orderItem.getProduct().getP_price())%>
										</td>
										<td width=50 height=26 align=center bgcolor="ffffff" class=t1></td>
									</tr>
									<!-- cart item end -->
									<%
									}
									%>
									<tr>
										<td width=640 colspan=4 height=26 bgcolor="ffffff" class=t1>
											<p align=right style="padding-top: 10px">
												<font color=#FF0000>총 주문 금액 : <%=new DecimalFormat("#,###").format(order.getO_price())%>
													원
												</font>
											</p>
										</td>
									</tr>
								</table>
							</form> <br />
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align=center>&nbsp;&nbsp; <a
										href="javascript:order_create_form_submit();" class=m1>구매/결재하기</a>
										&nbsp;&nbsp;<a href=product_list.jsp class=m1>계속 쇼핑하기</a>

									</td>
								</tr>
							</table></td>
					</tr>
				</table>
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="include_common_bottom.jsp" />
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>