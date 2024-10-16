package com.itwill.guest.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import jakarta.*;

//@WebServlet("/guest_main")
public class GuestMainServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forwardPath="forward:/WEB-INF/views/guest_main.jsp";
		
		
		
		
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
		/*
		 * RequestDispatcher rd=request.getRequestDispatcher(forwardPath);
		 * rd.forward(request, response);
		 */
	}
	
}
