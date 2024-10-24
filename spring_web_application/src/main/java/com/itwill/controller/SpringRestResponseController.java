package com.itwill.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.dto.Guest;

@Controller
public class SpringRestResponseController {
	/******response text*******/
	@GetMapping(value = "/response_string", produces = {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String response_string() {
		return "Hello string for javascript ajax                                request[한글]";
	}
	/*************/
	@GetMapping(value = "/response_html",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String response_html() {
		return "<h3>Hello string for javascript ajax request[한글]</h3><hr>";
	}

	@RequestMapping(value = "/response_json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Guest response_json() {
		
		Guest guest=new Guest(1, "PARK", "2024/10/24", "itwill@itwill.com", "homepage","title","content");
		return guest;
	}
	@RequestMapping(value = "/response_xml",produces = "text/xml;charset=UTF-8")
	@ResponseBody
	public Guest response_xml() {
		Guest guest=new Guest(1, "KIM", "2024/01/24", "guard@email.com","홈페이지", "타이틀", "내용");
		return guest;
	}
	@RequestMapping(value = "/response_json_list", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<Guest> response_json_list() {
		
		Guest guest=new Guest(1, "PARK", "2024/10/24", "itwill@itwill.com", "homepage","title","content");
		Guest guest1=new Guest(2, "eun-mee", "2024/10/24", "itwill@nave.com", "homepage","title","content");
		Guest guest2=new Guest(3, "EUN", "2024/10/24", "itwill@daum.com", "homepage","title","content");
		Guest guest3=new Guest(4, "JEE", "2024/10/24", "itwill@itwill.co.kr", "homepage","title","content");
		List<Guest> guestList=new ArrayList<>();
		guestList.add(guest3);
		guestList.add(guest2);
		guestList.add(guest1);
		guestList.add(guest);
		return guestList;
	}
	
	
}