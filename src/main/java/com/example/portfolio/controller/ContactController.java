package com.example.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.portfolio.domain.Contact;
import com.example.portfolio.dto.ContactForm;
import com.example.portfolio.service.ContactService;
import com.example.portfolio.service.EmailService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/contact")
public class ContactController {
	
	private final ContactService contactService;
	private final EmailService emailService;
	
	@GetMapping
    public String main(Model model) {
		Contact contact = contactService.getContactById(1);
		model.addAttribute("contact", contact);
        return "contact"; // index.html을 반환
    }
	
	@GetMapping("/register")
	public String contact(Model model) {
		return "contact-register"; 
	}
	
	@PostMapping("")
	public String createContact(@ModelAttribute Contact contact) {
		contactService.create(contact.getAddr(), contact.getTel(), contact.getEmail(), contact.getOpenHours());
		return "redirect:/contact";
	}
	
	@PostMapping("/send")
	public String sendContact(@ModelAttribute ContactForm contactForm, RedirectAttributes redirectAttributes) {
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
	    return "redirect:/contact";
	}
}
