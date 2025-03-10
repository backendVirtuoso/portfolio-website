package com.example.portfolio.dto;

import com.example.portfolio.entity.Project;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@Getter
@AllArgsConstructor
public class ProjectDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String backend;
    private String frontend;
    private String db;
    private String github;
    private String type;
    private String description;
    private String imagePaths;

    public ProjectDTO(Project project) {
        this.id = project.getId();
        this.backend = project.getBackend();
        this.frontend = project.getFrontend();
        this.db = project.getDb();
        this.github = project.getGithub();
        this.type = project.getType();
        this.description = project.getDescription();
        this.imagePaths = project.getImagePaths();
    }

    // 첫 번째 이미지 메인 화면
    public String getFirstImagePath() {
        return Optional.ofNullable(imagePaths)
                .filter(paths -> !paths.isEmpty())
                .map(paths -> paths.split(","))
                .filter(paths -> paths.length > 0)
                .map(paths -> paths[0].trim())
                .orElse(null);
    }

}
