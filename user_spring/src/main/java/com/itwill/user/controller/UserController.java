package com.itwill.user.controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.user.User;
import com.itwill.user.UserService;
/*
  /user_main 
  /user_write_form 
  /user_write_action 
  /user_login_form
  /user_login_action 
  /user_logout_action 
  /user_view 
  /user_modify_form
  /user_modify_action 
  /user_remove_action
 */
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
	/*
	@PostMapping("/user_write_action")
	public String user_write_action(@RequestParam("userid") String userId,
									@RequestParam("password") String password,
									@RequestParam("name") String name,
									@RequestParam("email") String email,
					RedirectAttributes redirectAttributes) 
//					throws Exception 
	{
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
				
				forwardPath="redirect:user_login_form.do";
				return forwardPath;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "user_error";
		}
		
		return "";
	}*/
	
	public String user_login_form() {
		return "";
	}

	public String user_login_action()  throws Exception{
		return "";
	}
	
	public String user_view() throws Exception{
		/*******login check******
		
		return "";
	}
	
	public String user_modify_form() throws Exception{
		/*******login check******/
		
		return "";
	}
	
	
	public String user_modify_action() throws Exception{
		/*******login check******/
	
		return "";
	}
	

	public String user_remove_action()throws Exception {
		/*******login check******/
		
		return "";
	}
	

	public String user_logout_action() {
		/*******login check******/
	
		return "";
	}
	
	
	
	
}















