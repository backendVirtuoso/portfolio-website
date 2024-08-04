package com.example.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@GetMapping("")
    public String main(Model model) {
        return "register"; 
    }
	
	
	
	@GetMapping("tech-stack-register")
	public String tech(Model model) {
		return "tech-stack-register"; 
	}
	
	@GetMapping("portfolio-details-register")
	public String portfolio(Model model) {
		return "portfolio-details-register"; 
	}
	
	@GetMapping("/contact-register")
	public String contact(Model model) {
		return "contact-register"; 
	}
}
