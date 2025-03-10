package com.example.portfolio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "backend", nullable = false)
    private String backend;

    @Column(name = "frontend", nullable = false)
    private String frontend;

    @Column(name = "db", nullable = false)
    private String db;

    @Column(name = "github", nullable = false)
    private String github;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "image_paths", nullable = false)
    private String imagePaths;

    private boolean isActive;

    public Project(String backend, String frontend, String db, String github, String type, String description, String imagePaths, boolean isActive) {
        this.backend = backend;
        this.frontend = frontend;
        this.db = db;
        this.github = github;
        this.type = type;
        this.description = description;
        this.imagePaths = imagePaths;
        this.isActive = isActive;
    }

    public String getFirstImagePath() {
        if (imagePaths != null && !imagePaths.isEmpty()) {
            String[] paths = imagePaths.split(",");
            if (paths.length > 0) {
                return paths[0].trim(); // Return the first image path, trimmed
            }
        }
        return null; // Return null if no images are found
    }
}
