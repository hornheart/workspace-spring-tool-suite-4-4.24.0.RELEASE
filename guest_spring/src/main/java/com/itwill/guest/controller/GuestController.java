package com.itwill.guest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.guest.Guest;
import com.itwill.guest.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class GuestController {
	@Autowired
	private UserService guestService;
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
	public String guest_list(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		try {
			List<Guest> guestList=guestService.guestList();
			request.setAttribute("guestList", guestList);
			forwardPath="forward:/WEB-INF/views/guest_list.jsp";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
		}
		return forwardPath;
	}
	
	@RequestMapping("/guest_view")
	public String guest_view(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		try {
			String guest_noStr=request.getParameter("guest_no");
			if(guest_noStr==null||guest_noStr.equals("")) {
				forwardPath="redirect:guest_list.jsp";
			}else {
				Guest guest=guestService.guestDetail(Integer.parseInt(guest_noStr));
				request.setAttribute("guest", guest);
				forwardPath="forward:/WEB-INF/views/guest_view.jsp";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		}
		return forwardPath;
	}
	@RequestMapping("/guest_write_form")
	public String guest_write_form() {//Spring의 뷰 리졸버가 JSP 파일을 찾을 수 있도록
		return "guest_write_form"; // /WEB-INF/views/ 하위에서 파일을 찾아뷰 이름만 반환
	}
	@RequestMapping("/guest_write_action")
	public String guest_write_action(HttpServletRequest request, HttpServletResponse response) {
	    String forwardPath="";
	    try {
	        String guest_name = request.getParameter("guest_name");
	        String guest_email = request.getParameter("guest_email");
	        String guest_homepage = request.getParameter("guest_homepage");
	        String guest_title = request.getParameter("guest_title");
	        String guest_content = request.getParameter("guest_content");

	        int guest_no = guestService.guestWrite(Guest.builder()
	            .guestName(guest_name)
	            .guestEmail(guest_email)
	            .guestHomepage(guest_homepage)
	            .guestTitle(guest_title)
	            .guestContent(guest_content)
	            .build());
//	        forwardPath = "forward:/WEB-INF/views/guest_view.jsp?guest_no=" + guest_no;
	        forwardPath = "redirect:/guest_view?guest_no=" + guest_no;
	    } catch (Exception e) {
	        e.printStackTrace();
	        forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
	    }
	    return forwardPath;
	}

	@RequestMapping("/guest_modify_form")
	public String guest_modify_form(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		try {
			forwardPath = "redirect:guest_main";
			String guest_noStr = request.getParameter("guest_no");
			Guest guest = guestService.guestDetail(Integer.parseInt(guest_noStr));
			request.setAttribute("guest", guest);
			forwardPath = "forward:/WEB-INF/views/guest_modify_form.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
		}
		return forwardPath;
	}
	@RequestMapping("/guest_modify_action")
	public String guest_modify_action(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		try {
			String guest_no = request.getParameter("guest_no");
			String guest_name = request.getParameter("guest_name");
			String guest_email = request.getParameter("guest_email");
			String guest_homepage = request.getParameter("guest_homepage");
			String guest_title = request.getParameter("guest_title");
			String guest_content = request.getParameter("guest_content");
			int rowCount = guestService.guestUpdate(Guest.builder()
									   .guestNo(Integer.parseInt(guest_no))
									   .guestName(guest_name)	
									   .guestEmail(guest_email)
									   .guestHomepage(guest_homepage)
									   .guestTitle(guest_title)
									   .guestContent(guest_content)
									   .build());
			// 수정된 내용을 뷰로 리다이렉트
			forwardPath = "redirect:/guest_view?guest_no=" + guest_no;
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/guest_error";
		}
		return forwardPath;
	}
	@RequestMapping("/guest_remove_action")
	public String guest_remove_action(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		try {
			String guest_noStr = request.getParameter("guest_no");
			int rowCount = guestService.guestDelete(Integer.parseInt(guest_noStr));
			// 삭제 후 리스트로 리다이렉트
			forwardPath = "redirect:guest_list";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/guest_error.jsp";
		}
		return forwardPath;
	}
	
	
	
}
