package com.itwill.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle_counter")
public class LifeCycleCounterServlet extends HttpServlet {
	private int count;
	public LifeCycleCounterServlet() {
		System.out.println("0.LifeCycleCounterServlet 기본생성자[최초호출시 단한번호출] 객체주소:"+this);
		System.out.println("0.LifeCycleCounterServlet 기본생성자[최초호출시 단한번호출] 객체주소:"+this);
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("1.init메쏘드 --> 생성자호출직후 단한번호출[객체초기화,리소스획득]");
	}
	
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("2."+request.getRemoteAddr()+ " 님의 요청에의해서 service메쏘드실행[요청시마다호출]:"+this);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body bgcolor=#40e0d0 style=font-size:9pt;line-height:140%;>");
		out.println("<center>		");
		out.println("현재까지의 페이지뷰 수");
		out.println("<font color=#0000FF>");
		out.println(++count);
		out.println("</font>");
		out.println(" 번입니다 ");
		out.println("</center> ");
		out.println("</body> ");
		out.println("</html>");
	}
	@Override
	public void destroy() {
		System.out.println("4.destroy: 서블릿객체가 메모리에서 해제될때호출");
	}
}