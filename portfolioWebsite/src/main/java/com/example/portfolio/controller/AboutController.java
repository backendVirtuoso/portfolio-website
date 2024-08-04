package com.example.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about")
public class AboutController {
	
	@GetMapping
	public String main(Model model) {
	    return "about"; // index.html을 반환
	}
	
	@GetMapping("/register")
	public String about(Model model) {
		return "about-register"; 
	}

}
