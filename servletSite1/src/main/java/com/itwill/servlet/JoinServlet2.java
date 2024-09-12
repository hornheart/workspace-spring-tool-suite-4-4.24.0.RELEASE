package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class JoinServlet1
 */
@WebServlet("/join2.do")
public class JoinServlet2 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * GET 방식으로 요청이 들어오면 05-03.form2.html로 방향재지정 (redirection)
   			response.sendRedirect("05-03.form2.html");
		 */
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<h3>호갱님죄송합니다.[잘못된요청방식(405)]</h3>");
		out.println("<a href='05-03.form2.html'>회원가입</a>");
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 응답객체 MIME타입 인코딩설절
		 */
		response.setContentType("text/html;charset=UTF-8");

		/*
		 * 응답스트림생성
		 */
		PrintWriter out = response.getWriter();

		/*
		 * 0.요청객체인코딩설절
		 */
		request.setCharacterEncoding("UTF-8");

		/*
		 * 1.파라메타받기
		 */
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		String repass=request.getParameter("repass");
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		String gender=request.getParameter("gender");
		String job=request.getParameter("job");
		String[] hobbies=request.getParameterValues("hobby");
		if(hobbies==null) {
			hobbies=new String[0];
		}
		
		/*
		 * 2.Service객체 가입메쏘드호출
		 */

		/*
		 * 3.클라이언트로 응답 출력
		 */
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("<style type='text/css'>");
		out.println("table{");
		out.println("width: 500px;");
		out.println("margin: 10px auto 0px auto;");
		out.println("}");
		out.println("td, tr, th {");
		out.println("	border: 1px solid black;");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h3 align='center'>가입정보결과</h3>");
		out.println("<table width='50%'>");
		out.println("		<tr>");
		out.println("			<th width='30%'>항목</th>");
		out.println("			<th width='50%'>입력값</th>");
		out.println("			<th width='20%' >비고</th>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>아이디</td>");
		out.printf("			<td>%s</td>",id);
		out.println("			<td rowspan='15'></td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>패쓰워드</td>");
		out.printf("			<td>%s</td>",pass);
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>비밀번호확인</td>");
		out.printf("			<td>%s</td>",repass);
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>이름</td>");
		out.printf("			<td>%s</td>",name);
		out.printf("		</tr>");
		out.println("		<tr>");
		out.println("			<td>주소</td>");
		out.printf("			<td>%s</td>",addr);
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>성별</td>");
		out.printf("			<td>%s</td>",gender);
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>직업</td>");
		out.printf("			<td>%s</td>",job);
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td rowspan='30'>취미</td>");
		if(hobbies.length==0) {
			out.println("		<tr>");
			out.printf("			<td>생략</td>");
			out.println("		</tr>");
			
		}else {
			
			for (String hobby : hobbies) {
				out.println("		<tr>");
				out.printf("			<td>%s</td>",hobby);
				out.println("		</tr>");
			}
		}
		out.println("		</tr>");
//		out.println("  		<tr>");
//		out.println("			<td>운동</td>");
//		out.println("		</tr>");
//		out.println("		<tr>");
//		out.println("			<td>기타</td>");
//		out.println("		</tr>");
		out.println("	</table>");
		out.println("</body>");
		out.println("</html>");

	}

}