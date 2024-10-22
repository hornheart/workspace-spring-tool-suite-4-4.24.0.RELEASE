package com.itwill.guest.controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;
import com.itwill.spring.mvc.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GuestViewController implements Controller {
	private GuestService guestService;

	public GuestViewController(){
		try {
			guestService = new GuestServiceImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		try {
			String guest_noStr = request.getParameter("guest_no");
			if (guest_noStr == null || guest_noStr.equals("")) {
				forwardPath = "redirect:guest_list.do";
			} else {
				Guest guest = guestService.guestDetail(Integer.parseInt(guest_noStr));
				request.setAttribute("guest", guest);
				forwardPath = "forward:/WEB-INF/views/guest_view.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/guest_error.jsp";

		}
		return forwardPath;
	}

}