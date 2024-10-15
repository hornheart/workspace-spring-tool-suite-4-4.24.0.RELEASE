
<%@page import="java.net.URLEncoder"%>
<%@page import="com.itwill.user.User"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%
	/*
	0  . GET방식요청일때 user_login_form.jsp로 redirection
	1  . 요청객체 인코딩설정
	2  . 파라메타 받기->2개
	3  . UserService객체생성
	4  . UserService.login() 메쏘드실행
	*/
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("user_login_form.jsp");
		return;
	}
	String userId=request.getParameter("userId");
	String password=request.getParameter("password");
	/*
	 * 회원로그인
	 * 
	 * 0:아이디존재안함
	 * 1:패쓰워드 불일치
	 * 2:로그인성공(세션)
	 */
	int result=	new UserService().login(userId, password);
	if(result==0){//0:아이디존재안함
		/*String msg1=userId+" 는 존재하지 않는 아이디입니다.";//한글 존재로 반드시 URLEncoder
		String queryString = "msg1="+msg1+"&userId="+userId+"&password="+password;
		queryString=URLEncoder.encode(queryString,"UTF-8");*/

		//case1 script
		//case2 redirect
		//response.sendRedirect("user_login_form.jsp?"+queryString);
		//case3 forward
		/* request.setAttribute("fuserId", userId); 
		request.setAttribute("fpassword", password);  */
		
		User fUser=new User(userId, password,"","");//=>>>>존재하지 않는 유저입니다
		String msg1=userId+" 는 존재하지 않는 아이디입니다.";
		
		request.setAttribute("juser", fUser);
		request.setAttribute("msg1", msg1);
		
		RequestDispatcher rd=request.getRequestDispatcher("user_login_form.jsp");
		rd.forward(request, response);
	}else if(result==1){//1.패스워드 불일치
		String msg2=password+" 는 존재하지 않는 패스워드입니다.";
		String queryString=URLEncoder.encode(msg2,"UTF-8");
		response.sendRedirect("user_login_form.jsp?"+queryString);
		
	}else if(result==2){//2.로그인성공
		session.setAttribute("sUserId", userId);//session의 user객체
		response.sendRedirect("user_main.jsp");
	}
	
	
	
%>