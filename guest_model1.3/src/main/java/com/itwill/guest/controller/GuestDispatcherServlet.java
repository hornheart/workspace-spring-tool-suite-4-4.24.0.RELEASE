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

@WebServlet(urlPatterns={"/guest_main","/guest_list",
		"/guest_view","/guest_write_form",
		"/guest_write_action","/guest_modify_form",
		"/guest_modify_action","/guest_remove_action"})
public class GuestDispatcherServlet extends HttpServlet {
	
	private GuestService guestService;
	
	public GuestDispatcherServlet() throws Exception {
		guestService=new GuestService();
	}
/*
	private GuestService guestService;
	public GuestDispatcherServlet() throws Exception{
		guestService=new GuestService();
	}
	*/
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException{
		//1.GuestDispatcherServlet요청분석
		String requestURI= request.getRequestURI();
		System.out.println(">>>>>>>"+requestURI);
		String contextPath=request.getContextPath();
		System.out.println("contextPath:"+contextPath);
		String command=requestURI.substring(contextPath.length());
		System.out.println("command"+command);
		
//		String forwardPath="";
		
	
		//2.GuestDispatcherServlet이 클라이언트 요청에 따른 비지니스실행 [Service객체 사용]
		String forwardPath="";
		if(command.equals("/guest_main")) {
			forwardPath="forward:/WEB-INF/views/guest_main.jsp";
		}else if (command.equals("/guest_list")) {
			try {
				request.setCharacterEncoding("UTF-8");
				List<Guest> guestList=guestService.guestList();
				request.setAttribute("guestList", guestList);
				forwardPath="forward:/WEB-INF/views/guest_list.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
			}
		}
		/**********forward or redirect
		
		 forward    --> forward:/WEB-INF/views/guest_xxx.jsp
		 redirect   --> redirect:guest_xxx
		 ******************************/
		
		
		 String[] pathArray=forwardPath.split(":"); 
		 String forwardOrRedirect=pathArray[0]; 
		 String path=pathArray[1];
		 if(forwardOrRedirect.equals("forward")) { 
			 RequestDispatcher rd = request.getRequestDispatcher(path); 
			 rd.forward(request, response); 
		 }else {
			 response.sendRedirect(path); 
		 }
		
		
	}
}
