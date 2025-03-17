package com.example.portfolio.controller;

import com.example.portfolio.dto.*;
import com.example.portfolio.service.EmailService;
import com.example.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;
    private final EmailService emailService;

    @GetMapping({"/", "/home", "/about", "/skill", "/portfolio", "/contact"})
    public String index(Model model) {
        // About 정보
        List<AboutDTO> about = portfolioService.getAbout();
        model.addAttribute("about", about);

        // 기술 스택 정보
        List<TechStackDTO> techStack = portfolioService.getTechStacks();
        model.addAttribute("techStack", techStack);

        // 프로젝트 목록
        List<ProjectDTO> project = portfolioService.getProjects();
        model.addAttribute("project", project);

        // 연락처 정보
        List<ContactDTO> contact = portfolioService.getContact();
        model.addAttribute("contact", contact);

        return "presentation/index";
    }

    @GetMapping("/portfolio/details/{id}")
    public String portfolio(@PathVariable("id") Long id, Model model) {
        // 특정 프로젝트 정보 가져오기
        ProjectDTO project = portfolioService.findById(id);
        model.addAttribute("project", project);
        
        // 전체 프로젝트 목록
        List<ProjectDTO> projects = portfolioService.getProjects();
        model.addAttribute("projects", projects);
        
        return "presentation/portfolio-details";
    }

    @PostMapping("/send")
    public String sendContact(@ModelAttribute ContactForm contactForm, RedirectAttributes redirectAttributes) {
        try {
            // 이메일 전송
            String subject = "[포트폴리오 문의] " + contactForm.getSubject();
            String body = String.format("보낸 사람: %s\n이메일: %s\n메시지: %s",
                          contactForm.getName(),
                          contactForm.getEmail(),
                          contactForm.getMessage()
            );
            emailService.sendEmail("h_leopold@naver.com", subject, body);
            redirectAttributes.addFlashAttribute("messageType", "success");
            redirectAttributes.addFlashAttribute("message", "Your message has been sent. Thank you!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("messageType", "error");
            redirectAttributes.addFlashAttribute("message", "Failed to send your message. Please try again.");
        }
        return "redirect:/";
    }
}