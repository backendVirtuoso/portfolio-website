package com.example.portfolio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tech_stack")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class TechStack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "backend", nullable = false)
    private String backend;

    @Column(name = "frontend", nullable = false)
    private String frontend;

    @Column(name = "db", nullable = false)
    private String db;

    @Column(name = "dev_tool", nullable = false)
    private String devTool;

    @Column(name = "version_management", nullable = false)
    private String versionManagement;

    @Column(name = "certificate", nullable = false)
    private String certificate;

    private boolean isActive;

    public TechStack(String backend, String frontend, String db, String devTool, String versionManagement, String certificate, boolean isActive) {
        this.backend = backend;
        this.frontend = frontend;
        this.db = db;
        this.devTool = devTool;
        this.versionManagement = versionManagement;
        this.certificate = certificate;
        this.isActive = isActive;
    }
}
