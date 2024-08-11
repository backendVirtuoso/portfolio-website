package com.example.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.portfolio.domain.About;
import com.example.portfolio.domain.Contact;
import com.example.portfolio.domain.Portfolio;
import com.example.portfolio.domain.TechStack;
import com.example.portfolio.repository.AboutRepository;
import com.example.portfolio.repository.ContactRepository;
import com.example.portfolio.repository.PortfolioRepository;
import com.example.portfolio.repository.TechStackRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
    private AboutRepository aboutRepository;
	@Autowired
	private TechStackRepository techStackRepository;
	@Autowired
	private PortfolioRepository portfolioRepository;
	@Autowired
	private ContactRepository contactRepository;
	
	@GetMapping
    public String main(Model model) {
		
		About about = aboutRepository.findById(1).orElse(null);
		TechStack techStack = techStackRepository.findById(1).orElse(null);
		List<Portfolio> portfolio = portfolioRepository.findAll();
		Contact contact = contactRepository.findById(1).orElse(null);

        model.addAttribute("about", about);
        model.addAttribute("techStack", techStack);
        model.addAttribute("portfolio", portfolio);
        model.addAttribute("contact", contact);
        
        return "home"; 
    }
	
}
