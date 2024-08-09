package com.example.portfolio.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.portfolio.domain.Portfolio;
import com.example.portfolio.service.PortfolioService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/portfolio")
public class PortfolioController {
	
	private final PortfolioService portfolioService;
	
	@GetMapping("")
    public String portfolio(Model model) {
		List<Portfolio> portfolioItems = portfolioService.getAllPortfolioItems();
        model.addAttribute("portfolioItems", portfolioItems);
        return "portfolio"; 
    }
	
	@GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model) {
        Portfolio project = portfolioService.findById(id);
        model.addAttribute("project", project);
        return "portfolio-details"; 
    }
	
	@GetMapping("/register")
	public String register(Model model) {
		return "portfolio-details-register"; 
	}
	
	@PostMapping("")
	public String createPortfolio(@ModelAttribute Portfolio portfolio, @RequestParam("imageFile") MultipartFile[] imageFiles) throws IOException {
		portfolioService.create(imageFiles, portfolio.getGithub(), portfolio.getFrontend(), 
                portfolio.getBackend(), portfolio.getDatabase(), portfolio.getType(), portfolio.getDescription());
		return "redirect:/portfolio";
	}
}
