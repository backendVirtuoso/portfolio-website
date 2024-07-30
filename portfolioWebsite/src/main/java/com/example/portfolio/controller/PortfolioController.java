package com.example.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/portfolio")
public class PortfolioController {
	
	@GetMapping
    public String main(Model model) {
        return "portfolio"; // index.html을 반환
    }
}
