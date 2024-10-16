package com.itwill.guest.controller;

import java.io.IOException;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/guest_write_action")
public class GuestWriteActionServlet extends HttpServlet {
	private GuestService guestService;
	public GuestWriteActionServlet() throws Exception {
		guestService = new GuestService();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forwardPath="";//action지워버림forwarding이 자주 일어나기 때문에
		try {
			
			if(request.getMethod().equalsIgnoreCase("GET")){
				/*
				 * response.sendRedirect("guest_main.jsp"); 
				 * return;
				 */
				forwardPath="redirect:guest_main";
			} else {
				
				String guest_name=request.getParameter("guest_name");
				String guest_email=request.getParameter("guest_email");
				String guest_homepage=request.getParameter("guest_homepage");
				String guest_title=request.getParameter("guest_title");
				String guest_content=request.getParameter("guest_content");
//				GuestService guestService=new GuestService();
				int guest_no=guestService.guestWrite(Guest.builder()
						.guestName(guest_name)
						.guestEmail(guest_email)
						.guestHomepage(guest_homepage)
						.guestTitle(guest_title)
						.guestContent(guest_content)
						.build()
						);
				//response.sendRedirect("guest_view?guest_no="+guest_no);
				forwardPath="redirect:guest_view?guest_no="+guest_no;
			}
		} catch (Exception e) {
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