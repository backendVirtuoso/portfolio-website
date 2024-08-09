package com.example.portfolio.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.portfolio.domain.Portfolio;
import com.example.portfolio.repository.PortfolioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PortfolioService {
	
	@Autowired
	private final PortfolioRepository portfolioRepository;
	private final String uploadDir = "src/main/resources/static/bootstrap/assets/img/portfolio/";
	
	public Portfolio create(MultipartFile[] imageFiles, String github, String frontend, 
            String backend, String database, String type, String description) throws IOException {

		// 업로드 디렉토리 존재 확인 및 생성
		Path uploadDirPath = Paths.get(uploadDir);
		if (!Files.exists(uploadDirPath)) {
		Files.createDirectories(uploadDirPath);
		}
		
		// 이미지 파일 저장 및 URL 생성
		List<String> imageUrls = Arrays.stream(imageFiles)
			.map(file -> {
				try {
				    return saveImage(file); // 이미지 저장 및 URL 반환
				} catch (IOException e) {
				    e.printStackTrace();
				    return null;
				}
			})
			.filter(url -> url != null)
			.collect(Collectors.toList());
		
		// Portfolio 객체 생성 및 필드 설정
		Portfolio portfolio = new Portfolio();
		portfolio.setGithub(github);
		portfolio.setFrontend(frontend);
		portfolio.setBackend(backend);
		portfolio.setDatabase(database);
		portfolio.setType(type);
		portfolio.setDescription(description);
		portfolio.setImagePaths(String.join(",", imageUrls)); // 이미지 URL들을 쉼표로 구분하여 저장
		
		// Portfolio 객체 저장 및 반환
		return this.portfolioRepository.save(portfolio);
	}
		
	private String saveImage(MultipartFile imageFile) throws IOException {
		Path path = Paths.get(uploadDir + imageFile.getOriginalFilename());
		Files.write(path, imageFile.getBytes());
		return imageFile.getOriginalFilename();
	}
	
	// 모든 포트폴리오 항목을 가져오는 메서드
    public List<Portfolio> getAllPortfolioItems() {
        return portfolioRepository.findAll();
    }
    
    public Portfolio findById(Integer id) {
        return portfolioRepository.findById(id)
                  .orElseThrow(() -> new RuntimeException("Portfolio not found with id " + id));
    }

}
