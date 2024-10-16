package com.itwill.guest.controller;

import java.io.IOException;

import com.itwill.guest.GuestService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//@WebServlet("/guest_remove_action")
public class GuestRemoveActionServlet extends HttpServlet {
	private GuestService guestService;
	public GuestRemoveActionServlet() throws Exception{
		guestService=new GuestService();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forwardPath="";//forward:/WEB-INF/views/guest_remove_action.jsp==>지웠음
		try {
			
			if(request.getMethod().equalsIgnoreCase("GET")){
//				response.sendRedirect("guest_main");
//				return;
				forwardPath="redirect:guest_mail";
			}
			request.setCharacterEncoding("UTF-8");
			String guest_noStr=request.getParameter("guest_no");
//			GuestService guestService=new GuestService();
			int rowCount=guestService.guestDelete(Integer.parseInt(guest_noStr));
//			response.sendRedirect("guest_list");
			forwardPath="redirect:guest_list";
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		}
		
		
		
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