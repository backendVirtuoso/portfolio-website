package com.example.portfolio.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.portfolio.domain.About;
import com.example.portfolio.service.AboutService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/about")
public class AboutController {
	
	private final AboutService aboutService;
	
	@GetMapping("")
	public String main(Model model) {
        About about = aboutService.getAboutById(1);
        model.addAttribute("about", about);
        return "about";
    }
	
	@GetMapping("/register")
	public String about(Model model) {
		return "about-register"; 
	}
	
	@PostMapping("")
    public String createAbout(@ModelAttribute About about, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        // 이미지 파일 처리 (저장 등)
        aboutService.create(about.getTitle(), about.getContent(), imageFile);
        return "redirect:/about";
    }

}
