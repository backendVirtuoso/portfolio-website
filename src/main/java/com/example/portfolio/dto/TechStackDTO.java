package com.example.portfolio.dto;

import com.example.portfolio.entity.TechStack;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TechStackDTO {
    private String backend;
    private String frontend;
    private String db;
    private String devTool;
    private String versionManagement;
    private String certificate;

    public TechStackDTO(TechStack techStack) {
        this.backend = techStack.getBackend();
        this.frontend = techStack.getFrontend();
        this.db = techStack.getDb();
        this.devTool = techStack.getDevTool();
        this.versionManagement = techStack.getVersionManagement();
        this.certificate = techStack.getCertificate();
    }
}
