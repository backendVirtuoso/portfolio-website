package com.example.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/portfolio-details")
public class PortfolioDetailsController {
	
	@GetMapping
    public String main(Model model) {
        return "portfolio-details"; // index.html을 반환
    }
}
