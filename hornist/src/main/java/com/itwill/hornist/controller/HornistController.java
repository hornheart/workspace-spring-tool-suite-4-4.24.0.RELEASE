package com.itwill.hornist.controller;

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
		/*@GetMapping("/hornist_list") // "/hornist_list" 요청이 들어오면 이 메소드가 실행됨
public String hornist_list(HttpServletRequest request, Model model) throws Exception {
    // hornistService를 통해 모든 Hornist 객체를 리스트로 가져옴
    List<Hornist> hornistList = hornistService.hornist_list();

    // 모델에 "hornistList"라는 이름으로 가져온 리스트를 추가
    model.addAttribute("hornistList", hornistList);

    // 정상적으로 처리되면 "hornist_list.jsp"로 포워딩
    return "forward:/WEB-INF/views/hornist_list.jsp";
}

		 * */
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
