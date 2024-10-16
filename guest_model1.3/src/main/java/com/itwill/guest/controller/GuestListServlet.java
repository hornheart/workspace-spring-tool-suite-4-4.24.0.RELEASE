package com.itwill.guest.controller;

import java.io.IOException;
import java.util.List;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//@WebServlet("/guest_list")
public class GuestListServlet extends HttpServlet{
	
	private GuestService guestService;
	
	public GuestListServlet() throws Exception {
		guestService=new GuestService();
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * forward시 상대경로는 context root(/guest_model1.1) 이후 모든디렉토리가가능하다
		 * /WEB-INF/views/guest_list.jsp
		 */
		String forwardPath="";
		 /*0.요청객체encoding설정
		  * 1.파라메타받기
		  * 2.GuestService객체생성
		  * 3.GuestService객체 guestList() 메쏘드호출*/
		try {
			 request.setCharacterEncoding("UTF-8");
//			 System.out.println(this);
//			 System.out.println(guestService);
			 
//	         GuestService guestService=new GuestService();
			 List<Guest> guestList=guestService.guestList();
			 request.setAttribute("guestList", guestList);
			 forwardPath="forward:/WEB-INF/views/guest_list.jsp";
		 
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		}
		/**********forward or redirect**************************/
		/*
		 forward    --> forward:/WEB-INF/views/guest_xxx.jsp
		 redirect   --> redirect:guest_xxx
		 */
		String[] pathArray=forwardPath.split(":");
		String forwardOrRedirect=pathArray[0];
		String path=pathArray[1];
		if(forwardOrRedirect.equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}else {
			response.sendRedirect(path);
		}
		/*******************************************************/
	}
}