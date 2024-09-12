package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JdbcServlet1
 */
@WebServlet("/jdbc1")
public class JdbcServlet1 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			
			/************데이타베이스 접속정보[124.198.47.195]*************/
			String driverClass="oracle.jdbc.OracleDriver";
			String url="jdbc:oracle:thin:@124.198.47.195:1521:xe";
			String user="jdeveloper01";
			String password="jdeveloper01";
			
			String selectSql="select no, name, phone, address from address order by no";
			Class.forName(driverClass);//try&catch
			Connection con =DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = con.prepareStatement(selectSql);
			ResultSet rs=pstmt.executeQuery();
			
			
			
//			response.setContentType("text/html;charset=UTF-8");
//			PrintWriter out = response.getWriter();     =============>상단으로 在배치
			
			out.println(
					"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"com.css\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<br>");
			out.println("<p align=center><font size=5 color=#0000FF>◈◈ JDBC 테스트 1◈◈</font><br>");
			out.println(
					"<table width=80% align=center border=1 cellspacing=0 bordercolordark=white bordercolorlight=#ADADAD>");
			out.println("<tr bgcolor=#000000 class=t1>");
			out.println("<td align=center height=20 width=25%><font color=#FFFFFF>번호</font></td>");
			out.println("<td align=center height=20 width=25%><font color=#FFFFFF>이름</font></td>");
			out.println("<td align=center height=20 width=25%><font color=#FFFFFF>전화번호</font></td>");
			out.println("<td align=center height=20 width=25%><font color=#FFFFFF>주소</font></td>");
			out.println("</tr>");
			
			while (rs.next()) {
				
				out.println("<tr class=t1>");
				out.printf("<td align=center width='25%%' height=20>%d</td>",rs.getInt("no"));
				out.printf("<td align=center width='25%%' height=20>%s</td>", rs.getString("name"));
				out.printf("<td align=center width='25%%' height=20>%s</td>",rs.getString("phone"));
				out.printf("<td align=center width='25%%' height=20>%s</td>", rs.getString("address"));
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html> ");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("<h3>[서버창을 확인하세요]</h3>");
		} finally {
			
		}
		

	}// end serivce
}// end class
