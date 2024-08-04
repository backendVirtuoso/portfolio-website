package com.example.portfolio.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tech_stack")
public class TechStack {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "database", nullable = false)
    private String database;

    @Column(name = "dev_tool", nullable = false)
    private String devTool;

    @Column(name = "frontend", nullable = false)
    private String frontend;

    @Column(name = "certificate", nullable = false)
    private String certificate;

    @Column(name = "version_management", nullable = false)
    private String versionManagement;

    @Column(name = "backend", nullable = false)
    private String backend;
	
}
