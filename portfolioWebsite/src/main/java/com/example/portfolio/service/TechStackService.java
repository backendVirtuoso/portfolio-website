package com.example.portfolio.service;

import org.springframework.stereotype.Service;

import com.example.portfolio.domain.TechStack;
import com.example.portfolio.repository.TechStackRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TechStackService {
	
	private final TechStackRepository techStackRepository;
	
	public TechStack create(String database, String devTool, String frontend, 
							String certificate, String versionManagement, String backend) {
		TechStack techStack = new TechStack();
		techStack.setDatabase(database);
		techStack.setDevTool(devTool);
		techStack.setFrontend(frontend);
		techStack.setCertificate(certificate);
		techStack.setVersionManagement(versionManagement);
		techStack.setBackend(backend);
		this.techStackRepository.save(techStack);
		return techStack;
	}
	
	public TechStack getTechStackById(Integer id) {
        return techStackRepository.findById(id).orElse(null); 
    }

}
