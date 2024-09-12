package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/join1")
public class JoinSevlet1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<h3>호갱님죄송합니다.[잘못된요청방식(405)]</h3>");
		out.println("<a href='05-03.form1.html'>가입하기</a>");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
/*1.parameter */
		String id=request.getParameter("id");
		String password=request.getParameter("pass");
		String email1=request.getParameter("email1");
		String email2=request.getParameter("email2");
		String gender=request.getParameter("gender");
//		String favorite=request.getParameter("favorite");===>1개 만 오기 때문에 메소드가 따로 존재 함
		String[] favorites=request.getParameterValues("favorite");
		if(favorites==null) {
			favorites=new String[0];
		}
		String birthday=request.getParameter("birthday");
		String message=request.getParameter("message");
		
		/*
		 * 2.업무실행(Service객체메소드 호출)
		 */

		/*
		 * 3.클라이언트 응답출력
		 */
		out.println("<h1>가입정보</h1>");
		out.println("<ul>");
		out.printf("<li>아이디:%s</li>",id);
		out.printf("<li>이메일:%s</li>",email1+"@"+email2);
		out.printf("<li>성별:%s</li>",gender);
		out.printf("<li>생일:%s</li>",birthday);
		out.printf("<li>가입인사:%s</li>",message);
		out.printf("<li>관심사");
		out.println("<ul>");
		for (String favorite : favorites) {
			out.printf("<li>%s</li>",favorite);
		}
		out.println("</ul>");
		out.printf("</li>");
		out.println("</ul>");
		out.println("<a href='05-03.forml.html'>가입폼</a>");
		
	}
}
