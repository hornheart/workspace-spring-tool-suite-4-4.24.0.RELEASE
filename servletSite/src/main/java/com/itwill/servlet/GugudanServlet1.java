package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/gugudan")
public class GugudanServlet1 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<meta charset='UTF-8'>");
		out.println("<TITLE>방가워요 서블릿</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<center><H2>서블릿 잘났어 정말 별꼴이야!!!!!!!!!</H2><center>");
		out.println("<img src='tomcat.gif'/>");

		out.println("<center><H2>서블릿 구구단</H2></center>");
		out.println("<table border=1 width=600 bgcolor=#CCFF33 bordercolordark=#FF6600 cellspacing=0>");
		out.println("<tr>");
		/*
		out.println("	<td align=center>2*1=2</td>");
		out.println("	<td align=center>3*1=2</td>");
		out.println("	<td align=center>4*1=2</td>");
		out.println("	<td align=center>5*1=2</td>");
		out.println("	<td align=center>6*1=2</td>");
		out.println("	<td align=center>7*1=2</td>");
		out.println("	<td align=center>8*1=2</td>");
		out.println("	<td align=center>9*1=2</td>");
		for(int i=2; i<=9;i++) {
			for (int j = 1; j <=9 ; j++) {
				out.printf("%d*%d=%d\t", i,j,(i*j));
			}
			out.println();
		}
		 */
		for(int i=1; i<=9;i++) {
			out.println("<tr>");
			for (int j = 2; j <=9 ; j++) {
				out.printf("<td align=center>%d*%d=%d", j,i,(i*j));
			}
			out.println();
		}
		
		
		out.println("</tr>");
		out.println("</table>");
		out.println("<br/>");
		out.println("</BODY>");
		out.println("</HTML>");
	}
}
