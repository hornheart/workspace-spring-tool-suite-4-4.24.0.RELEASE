package com.itwill.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.user.User;
import com.itwill.user.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	public UserController() {
		System.out.println("###생성자출력###");
	}
	
	@GetMapping("/user_main")
	public String user_main() {
		return "user_main";
	}
	
	@GetMapping("/user_write_form")
	public String user_write_form() {
		return "user_write_form";
	}
	
	@PostMapping("/user_write_action")
	public String user_write_action(@RequestParam("userId") String userId,
									@RequestParam("password") String password,
									@RequestParam("name") String name,
									@RequestParam("email") String email,
					RedirectAttributes redirectAttributes){
		User user=new User(userId,password,name,email);
		System.out.println(user);
		String forwardPath="";
		try {
			int result=userService.create(user);
			if(result ==-1){
				String msg=userId+" 는 이미존재하는 아이디입니다.";
				redirectAttributes.addAttribute("msg", msg);
				redirectAttributes.addAttribute("fuser", user);
				return "redirect:user_view";
			}else if(result ==1){
				
				forwardPath="redirect:user_login_form";
				return forwardPath;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "user_error";
		}
		
		return "";
	}
	
	@GetMapping("/user_login_form")
	public String user_login_form() {
		return "user_login_form";
	}

	@PostMapping("/user_login_action")
	public String user_login_action(HttpServletRequest request, HttpServletResponse response, 
																Model model)  /*throws Exception*/{
		try {
			String userId= request.getParameter("userId");
			String password= request.getParameter("password");
			int result=userService.login(userId, password);
			if (result==0) {
				String msg1=userId+" 는 존재하지 않는 아이디입니다.";
				model.addAttribute("msg1",msg1);
				model.addAttribute("fuser",new User(userId,password,"",""));
				return "user_login_form";
			} else if (result==1) {
				String msg2="패스워드가 일치하지 않습니다.";
				model.addAttribute("msg2",msg2);
				model.addAttribute("fuser",new User(userId,password,"",""));
				return "user_login_form";
			} else if(result==2){
				HttpSession session=request.getSession();
				session.setAttribute("sUserId", userId);
				return "redirect:user_main";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	/*
	@GetMapping("/user_view")
	public String user_view(@RequestParam(value = "userId", required = false) String userId,
	                        HttpServletRequest request,
	                        Model model) {
	    HttpSession session = request.getSession();
	    String sUserId = (String) session.getAttribute("sUserId");

	    // 로그인되지 않은 경우
	    if (sUserId == null) {
	        return "redirect:user_login_form.do";
	    }

	    // userId가 없을 경우 user_main으로 이동
	    if (userId == null) {
	        return "user_main";
	    }

	    // userId가 있을 경우 user_view로 이동
	    try {
	        User loginUser = userService.findUser(userId);
	        model.addAttribute("loginUser", loginUser);
	        return "user_view";
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "user_error";
	    }
	}

	@GetMapping(value = "/user_view",params = "!userId")
	public String user_view() {
		return "user_main";
	}
	@GetMapping(value = "/user_view",params = "userId")
	public String user_view(@RequestParam("userId") String userId,HttpServletRequest request,
									Model model) {
		HttpSession session=request.getSession();
		String sUserId=(String)session.getAttribute("sUserId");
		if(sUserId==null) {
			return "redirect:user_login_form.do";
		}
		try {
			User loginUser=userService.findUser(userId);
			model.addAttribute("loginUser",loginUser);
			return "user_view";
		} catch (Exception e) {
			e.printStackTrace();
			return "user_error";
		}
	}*/
	@GetMapping("/user_view")
	public String user_view(HttpServletRequest request, Model model) {
	    HttpSession session = request.getSession();
	    String sUserId = (String) session.getAttribute("sUserId");
	    if (sUserId == null) {
	        return "redirect:user_login_form";
	    }
	    try {
	        User loginUser = userService.findUser(sUserId);
	        model.addAttribute("loginUser", loginUser);
	        return "user_main";
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "forward:user_error";
	    }
	}

	
	@PostMapping("/user_modify_form")
	public String user_modify_form(HttpServletRequest request,
			@RequestParam("userId") String userId,
											Model model) /*throws Exception*/{
		HttpSession session=request.getSession();
		String sUserId=(String)session.getAttribute("sUserId");
		if (sUserId==null) {
			return "redirect:user_login_form";
		}
		try {
			User user=userService.findUser(sUserId);
			model.addAttribute("user",user);
			return "user_modify_form";
		} catch (Exception e) {
			e.printStackTrace();
			return "user_error";
		}
	}

	@PostMapping("/user_remove_action")
	public String user_remove_action(@RequestParam("userId") String userId)/*throws Exception*/ {
		/**/return null;
	}
	@GetMapping("/user_logout_action")
	public String user_logout_action(HttpServletRequest request
									/* @RequestParam("userId") String userId,
									 @RequestParam("password") String password*/) {
		HttpSession session = request.getSession();
		String sUserId=(String)session.getAttribute("sUserId");
		if(sUserId==null) {
			return "redirect:user_login_form";
		}
		
		session.invalidate();
		return "redirect:user_main";
	}
	
	@GetMapping(value = {"/user_write_action","/user_modify_form","/user_modify_action","/user_remove_action"})
	public String user_get() {
		return "redirect:user_main";
	}
	
}