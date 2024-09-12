package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle_image_counter")
public class LifeCycleCounterImageServlet extends HttpServlet {
	
	private int count;
	public void Servlet() {
		System.out.println("객체주소"+this);
	}
	
	@Override
	public void init(ServletConfig config )throws ServletException{
		super.init(config);
		System.out.println("init 메서드 호출 성공?");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("2.service 메쏘드실행(count="+count+") -->클라이언트가 요청할때마다실행");
		/*
		 * 응답헤더의 contentType설정
		 */
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =response.getWriter();
		// HTML 응답 작성
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>페이지 뷰 카운터</title>");
		out.println("</head>");
		out.println("<body bgcolor=#40e0d0 style=\"font-size: 9pt; line-height: 140%;\">");
		out.println("	<center>");
		/*
		  img 태그를 사용해서 출력
		
		 */
		String countStr = Integer.toString(count+1); // count의 자릿수를 구하기위해 문자열로 변환
		for(int i = 0;i<countStr.length();i++) {	// 숫자가 한자릿수면 길이 1, 두자릿수면 길이 2
			out.println("<img src='image/"+countStr.charAt(i)+".png'>");	
			// 해당 자리수의 문자열 값을 그대로 가져와서 사용가능 인덱스는 0부터시작
		}
		
		out.println("		현재까지의 페이지뷰수 <font color=#0000FF> "+ ++count +"</font> 번입니다");
		out.println("<br>");
		out.println("현재까지의 페이지뷰수");
		/*
		out.println("<img src='image/1.png'>");
		out.println("<img src='image/5.png'>"); 
		*/
		out.println(request.getRemoteAddr()+this);
		out.println(" 번입니다");
		out.println("	</center>");
		out.println("</body>");
		out.println("</html>");
	}
	@Override
	public void destroy() {
		System.out.println("서블릿 해제");
	}
}
