package com.itwill.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class SpringCustomTagSPELController {
	@GetMapping("/jstl_fmt_i18n")
	public String jstl_fmt_i18n() {
		return "jstl_fmt_i18n";
	}
	
	@GetMapping("/spring_customtag_spel")
	public String spring_customtag_spel() {
		return "spring_customtag_spel";
	}
}