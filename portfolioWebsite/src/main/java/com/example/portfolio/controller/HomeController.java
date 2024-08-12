package com.example.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.portfolio.domain.About;
import com.example.portfolio.domain.Contact;
import com.example.portfolio.domain.Portfolio;
import com.example.portfolio.domain.TechStack;
import com.example.portfolio.dto.ContactForm;
import com.example.portfolio.repository.AboutRepository;
import com.example.portfolio.repository.ContactRepository;
import com.example.portfolio.repository.PortfolioRepository;
import com.example.portfolio.repository.TechStackRepository;
import com.example.portfolio.service.EmailService;

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
	@Autowired
    private EmailService emailService;
	
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
	
	@PostMapping("/send")
    public String sendHome(@ModelAttribute ContactForm contactForm, RedirectAttributes redirectAttributes) {
        try {
            // 이메일 전송
            String subject = contactForm.getSubject();
            String body = "보낸 사람: " + contactForm.getName() + "\n" +
                          "이메일: " + contactForm.getEmail() + "\n" +
                          "메시지: " + contactForm.getMessage();
            emailService.sendEmail("h_leopold@naver.com", subject, body);

            // 성공 메시지 전달
            redirectAttributes.addFlashAttribute("messageType", "success");
            redirectAttributes.addFlashAttribute("message", "Your message has been sent. Thank you!");
        } catch (Exception e) {
            // 실패 메시지 전달
            redirectAttributes.addFlashAttribute("messageType", "error");
            redirectAttributes.addFlashAttribute("message", "Failed to send your message. Please try again.");
        }
        return "redirect:/home"; 
    }
	
}
