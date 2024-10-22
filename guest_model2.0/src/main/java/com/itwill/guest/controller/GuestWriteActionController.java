package com.itwill.guest.controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;
import com.itwill.spring.mvc.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GuestWriteActionController implements Controller {
	private GuestService guestService;
	public GuestWriteActionController(){
		try {
			guestService = new GuestServiceImpl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		try {
			if (request.getMethod().equalsIgnoreCase("GET")) {
				forwardPath = "redirect:guest_main.do";
			} else {
				String guest_name = request.getParameter("guest_name");
				String guest_email = request.getParameter("guest_email");
				String guest_homepage = request.getParameter("guest_homepage");
				String guest_title = request.getParameter("guest_title");
				String guest_content = request.getParameter("guest_content");

				int guest_no = guestService.guestWrite(Guest.builder().guestName(guest_name).guestEmail(guest_email)
						.guestHomepage(guest_homepage).guestTitle(guest_title).guestContent(guest_content).build());
				forwardPath = "redirect:guest_view.do?guest_no=" + guest_no;
			}
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
		}
		return forwardPath;
	}

}