package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//#1. jakarta.servlet.http.HttpServlet 클래스를 상속 받아야한다. 
public class HelloTextServlet extends HttpServlet{
	//#2. HttpServlet doGet(),doPost(),service() 메쏘드를 오버라이딩 해야한다. 
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//#2-1.  클라이언트에 전송할 데이타의 타입(종류)설정
		response.setContentType("text/plain;charset=UTF-8");
		
		//#2-2.  클라이언트에데이타를 전송하기위한 출력스트림 생성
		PrintWriter out=response.getWriter();
		//#2-3. 클라이언트로 데이타(text) 전송 
		
		for (int i = 0; i < 100; i++) {
			out.println("Hello text "+(i+1)+"[ dynamic web resource] !!!");
			
		}
		/*
		out.println("Hello text 1[ dynamic web resource] !!!");
		out.println("Hello text 2[ dynamic web resource] !!!");
		out.println("Hello text 3[ dynamic web resource] !!!");
		out.println("Hello text 4[ dynamic web resource] !!!");*/
	}

}