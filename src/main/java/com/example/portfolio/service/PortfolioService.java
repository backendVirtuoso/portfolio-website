package com.example.portfolio.service;

import com.example.portfolio.dto.*;
import com.example.portfolio.repository.*;
import com.example.portfolio.entity.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final PresentationRepository presentationRepository;

    @Transactional(readOnly = true)
    public List<AboutDTO> getAbout() {
        return presentationRepository.getActiveAbouts().stream()
                .map(AboutDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<TechStackDTO> getTechStacks() {
        return presentationRepository.getActiveTechStacks().stream()
                .map(TechStackDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<ProjectDTO> getProjects() {
        return presentationRepository.getActiveProjects().stream()
                .map(ProjectDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<ContactDTO> getContact() {
        return presentationRepository.getActiveContacts().stream()
                .map(ContactDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public ProjectDTO findById(Long id) {
        Project project = presentationRepository.findProjectById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다. id=" + id));
        return new ProjectDTO(project);
    }
} 