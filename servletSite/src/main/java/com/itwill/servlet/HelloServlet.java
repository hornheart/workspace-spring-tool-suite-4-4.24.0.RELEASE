package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.sql.rowset.serial.SerialException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	@Override
	protected void service (HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
//		out.println("");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		int no=(int)(Math.random()*10)+1;
		
		for (int i = 0; i < 5; i++) {
			out.println("	<h1>Hello Servlet(안녕서블릿)["+(i+1)+"]</h1><hr>");
		}
		out.println("</body>");
		
		out.println("</html>");
		
	}
	
}
