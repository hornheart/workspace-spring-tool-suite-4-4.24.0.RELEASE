package com.itwill.guest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.hornist.Hornist;
import com.itwill.hornist.HornistService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HornistController {
	@Autowired
	private HornistService hornistService;
	
	@GetMapping("/hornist_main")
	public String hornist_main() {
		return "hornist_main";
	}
	@GetMapping("/hornist_list")
	public String hornist_list(HttpServletRequest request) throws Exception {
		List<Hornist> hornistList= hornistService.hornist_list();
		request.setAttribute("hornistList", hornistList);
		return "hornist_list";
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
	
	
	
	
	
}
