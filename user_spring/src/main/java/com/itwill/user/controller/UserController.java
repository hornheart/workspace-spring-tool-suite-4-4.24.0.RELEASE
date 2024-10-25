package com.itwill.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.exception.ExistedUserException;
import com.itwill.user.exception.PasswordMismatchException;
import com.itwill.user.exception.UserNotFoundException;

import jakarta.servlet.http.HttpSession;
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
	private UserService userService;
	@RequestMapping()
	public String user_main() {
		return "";
	}
	public String user_write_form() {
		return "";
	}
	
	public String user_write_action() throws Exception {
		return "";
	}
	
	public String user_login_form() {
		return "";
	}

	public String user_login_action()  throws Exception{
		return "";
	}
	
	public String user_view() throws Exception{
		/*******login check******/
		
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















