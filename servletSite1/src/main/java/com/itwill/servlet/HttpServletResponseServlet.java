package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/response")
public class HttpServletResponseServlet extends HttpServletRequestServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();

		String cmd=request.getParameter("cmd");
		if(cmd==null || cmd.equals(" ")) {
			response.sendRedirect("04.HttpServletResponse.html");
			return;
		}
		
		if(cmd.equals("nomal")) {//정상응답=>line(상태코드200), header, body(deta전송)
			out.println("<h3>정상응답</h3>");
		}else if (cmd.equals("error")) {//에러응답 =>line(상태코드 4xx,5xx), body(deta 無, ->보낼 수 없음)
//			response.sendError(HttpServletResponse.SC_NOT_FOUND);
//			response.sendError(500);
			response.sendError(403);
		}else if (cmd.equals("redirect")) {//(경로변경)방향在지정=>line(상태코드 302), 
//			header[Location:index.html (redirection url)포함], body
			response.sendRedirect("./index.html");
		}else {
			
		}
	
	}
}