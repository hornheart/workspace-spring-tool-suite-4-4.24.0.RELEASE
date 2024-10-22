package com.itwill.guest.controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;
import com.itwill.spring.mvc.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GuestModifyActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		try {
			if (request.getMethod().equalsIgnoreCase("GET")) {
				forwardPath = "redirect:guest_main";
			} else {
				String guest_no = request.getParameter("guest_no");
				String guest_name = request.getParameter("guest_name");
				String guest_email = request.getParameter("guest_email");
				String guest_homepage = request.getParameter("guest_homepage");
				String guest_title = request.getParameter("guest_title");
				String guest_content = request.getParameter("guest_content");
				GuestService guestService = new GuestServiceImpl();
				int rowCount = guestService.guestUpdate(Guest.builder().guestNo(Integer.parseInt(guest_no))
						.guestName(guest_name).guestEmail(guest_email).guestHomepage(guest_homepage)
						.guestTitle(guest_title).guestContent(guest_content).build());
				forwardPath = "redirect:guest_view.do?guest_no=" + guest_no;
			}
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
		}
		return forwardPath;
	}

}
