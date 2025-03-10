package com.example.portfolio.repository;

import com.example.portfolio.entity.About;
import com.example.portfolio.entity.Contact;
import com.example.portfolio.entity.Project;
import com.example.portfolio.entity.TechStack;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PresentationRepository {
    private final AboutRepository aboutRepository;
    private final ContactRepository contactRepository;
    private final ProjectRepository projectRepository;
    private final TechStackRepository techStackRepository;

    public PresentationRepository(AboutRepository aboutRepository, ContactRepository contactRepository, ProjectRepository projectRepository, TechStackRepository techStackRepository) {
        this.aboutRepository = aboutRepository;
        this.contactRepository = contactRepository;
        this.projectRepository = projectRepository;
        this.techStackRepository = techStackRepository;
    }

    public List<About> getActiveAbouts() {
        return aboutRepository.findAllByIsActive(true);
    }

    public List<Contact> getActiveContacts() {
        return contactRepository.findAllByIsActive(true);
    }

    public List<Project> getActiveProjects() {
        return projectRepository.findAllByIsActive(true);
    }

    public List<TechStack> getActiveTechStacks() {
        return techStackRepository.findAllByIsActive(true);
    }

    public Optional<Project> findProjectById(Long id) {
        return projectRepository.findById(id);
    }
}
