package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/post_login")
public class PostLoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		/*CASE1
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<h3>잘못 된 요청방식405</h3>");
		out.println("<a href='05-02.login_post.html'>LOGIN</h3>");*/
//		response.sendError(405," 잘못 된 요청 ");
//		response.sendError(403," 접근금지 ");
		response.sendRedirect("05-02.login_post.html");//CASE2
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		/*
		 * 1. 요청시 전송되는 파라메타받기
		 *    <form action="get_login" method="get">
					아이디:<input type="text" name="id"><br/>
					패에쓰:<input type="password" name="pass"><br/><br/>
				</form>	
		 */
		
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");

		/*
		 * 2.서비스 객체를 사용해서 업무(로그인 실행)
		 */
		boolean isMember1=id.equals("xxxx")&& pass.equals("1111");
		boolean isMember2=id.equals("yyyy")&& pass.equals("2222");
		
		
		/*
		 * 3. client로 출력
		 */
		out.println("<h1>POST LOGIN결과</h1><hr>");
		if(isMember1 || isMember2) {
			out.println("<h3>"+id+"님 로그인 성공</h3>");
			out.println("<a href ='index.html '>메인으로</a>");
		}else {
			out.println("<h3>"+id+"님 로그인 실패</h3>");
			out.println("<a href ='05-02.login_post.html '>again</a>");
			
		}
		
	
	}

}
