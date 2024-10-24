package com.itwill.guest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.guest.GuestService;

@Controller
public class GuestController {
	@Autowired
	private GuestService guestService;
	public GuestController() {
		System.out.println("### GuestController()생성자");
	}
	@GetMapping("/guest_main")
	public String guest_main() {
		return "guest_main";
	}
	/*
	<<요청 url(command)>>
	/guest_main			 --forward --> guest_main.jsp
	/guest_list			 --forward --> guest_list.jsp
	/guest_view			 --forward --> guest_view.jsp
	/guest_write_form	 --forward --> guest_write_form.jsp
	/guest_write_action  --redirect--> guest_list
	/guest_modify_form	 --forward --> guest_modify_form.jsp
	/guest_modify_action --redirect--> guest_view
	/guest_remove_action --redirect--> guest_list
	 */
	
	@RequestMapping("/guest_list")
	public String guest_list() {
		return "forward:/WEB-INF/views/guest_list.jsp";
	}
	@RequestMapping("/guest_view")
	public String guest_view() {
		return "forward:/WEB-INF/views/guest_view.jsp";
	}
	@RequestMapping("/guest_write_form")
	public String guest_write_form() {
		return "forward:/WEB-INF/views/guest_write_form.jsp";
	}
	@RequestMapping("/guest_write_action")
	public String guest_write_action() {
		return "redirect:/guest_list.jsp";
	}
	@RequestMapping("/guest_modify_form")
	public String guest_modify_form() {
		return "forward:/WEB-INF/views/guest_modify_form.jsp";
	}
	@RequestMapping("/guest_modify_action")
	public String guest_modify_action() {
		return "redirect:/guest_view.jsp";
	}
	@RequestMapping("/guest_remove_action")
	public String guest_remove_action() {
		return "redirect:/guest_list.jsp";
	}
	
	
	
}
