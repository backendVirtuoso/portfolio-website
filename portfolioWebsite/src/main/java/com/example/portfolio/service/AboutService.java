package com.example.portfolio.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.portfolio.domain.About;
import com.example.portfolio.repository.AboutRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AboutService {
	
	@Autowired
	private final AboutRepository aboutRepository;
	private final String uploadDir = "src/main/resources/static/bootstrap/assets/img/about/";
	
	public About create(String title, String content, MultipartFile imageFile) throws IOException {
		About about = new About();
		about.setTitle(title);
		about.setContent(content);
		
		if (!imageFile.isEmpty()) {
	        String imageUrl = saveImage(imageFile); // 이미지 저장 후 URL 반환 메서드
	        about.setImgUrl(imageUrl);
	    }
		
		this.aboutRepository.save(about);
		return about;
	}
	
	private String saveImage(MultipartFile imageFile) throws IOException {
		byte[] bytes = imageFile.getBytes();
		Path path = Paths.get(uploadDir + imageFile.getOriginalFilename());
		Files.write(path, bytes);
		return imageFile.getOriginalFilename();
	}
	
	public About getAboutById(Integer id) {
        return aboutRepository.findById(id).orElse(null); 
    }

}
