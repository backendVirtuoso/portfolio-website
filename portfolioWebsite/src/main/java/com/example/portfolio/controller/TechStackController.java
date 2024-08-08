package com.example.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.portfolio.domain.TechStack;
import com.example.portfolio.service.TechStackService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/tech-stack")
@RequiredArgsConstructor
public class TechStackController {
	
	private final TechStackService techStackService;
	
	@GetMapping
    public String main(Model model) {
		TechStack techStack = techStackService.getTechStackById(1);
		model.addAttribute("techStack", techStack);
        return "tech-stack"; 
    }
	
	@PostMapping("")
    public String createTechStack(@ModelAttribute TechStack ts) {
        // 이미지 파일 처리 (저장 등)
		techStackService.create(ts.getDatabase(), ts.getDevTool(), ts.getFrontend(), ts.getCertificate(), ts.getVersionManagement(), ts.getBackend());
        return "redirect:/tech-stack";
    }
	
	
}
