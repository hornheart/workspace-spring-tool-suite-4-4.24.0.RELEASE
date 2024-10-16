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

//@WebServlet("/guest_view")
public class GuestViewServlet extends HttpServlet {
	private GuestService guestService;

	public GuestViewServlet() throws Exception{
		guestService = new GuestService();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		* 0.요청객체encoding설정
//		  * 1.gust_no 파라메타받기
//		  * 2.GuestService객체생성
//		  ==>* 3.GuestService객체 selectByNo(guest_no) 메쏘드호출
		/*
		 * 4.GuestService객체 selectByNo(guest_no)메소드 호출*/
		String forwardPath = "";
		try {
			
			request.setCharacterEncoding("UTF-8");
			String guest_noStr=request.getParameter("guest_no");
			if(guest_noStr==null||guest_noStr.equals("")){
				/*
				 * response.sendRedirect("guest_list"); 
				 * return;
				 */
				forwardPath="redirect:guest_list";
			} else {
				
				Guest guest = 
						guestService.guestDetail(Integer.parseInt(guest_noStr));
				request.setAttribute("guest", guest);
				forwardPath="forward:/WEB-INF/views/guest_view.jsp";
			}

		} catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		}
//		  if(guest==null){
				/*출력불가 forwarding만
				 * out.println("<script>"); 
				 * out.println("alert('존재하지않는 게시물입니다.');");
				 * out.println("location.href='guest_list.jsp';"); 
				 * out.println("</script>");
				 */
//			  return;
//		  }
		
		
		/*******forward or redirect
		 * forward --> forward:/WEB-INF/views/guest_list.jsp
		 * redirect --> redirect:guest_xxx
		 * 
		 * ************/
		String[] pathArray=forwardPath.split(":");//split의 메소드는 JAVA_API servlet에서 거론했으나...;;
		String forwardOrRedirct=pathArray[0];
		String path=pathArray[1];
		if(forwardOrRedirct.equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
			
		}else {
			response.sendRedirect(path);
		}
		
//		String forwardPath = "/WEB-INF/views/guest_view.jsp";
	}
}