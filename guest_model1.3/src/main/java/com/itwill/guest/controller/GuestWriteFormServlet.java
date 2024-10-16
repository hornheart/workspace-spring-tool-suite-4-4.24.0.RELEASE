package com.itwill.guest.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//@WebServlet("/guest_write_form")
public class GuestWriteFormServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * forward시 상대경로는 어떤context root(/guest_model1.1) 이후 모든디렉토리가가능하다
		 */
		String forwardPath="forward:/WEB-INF/views/guest_write_form.jsp";
		/*******forward or redirect************/
		String[] pathArray=forwardPath.split(":");//split의 메소드는 JAVA_API servlet에서 거론했으나...;;
		String forwardOrRedirct=pathArray[0];
		String path=pathArray[1];
		if(forwardOrRedirct.equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
			
		}else {
			response.sendRedirect(path);
		}
		/***************************************/
	}
}