package com.example.portfolio.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity 
public class Portfolio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;

	@Column(name = "github", nullable = false)
	private String github;
	
	@Column(name = "frontend", nullable = false)	
	private String frontend;
	
	@Column(name = "backend", nullable = false)	
	private String backend;
	
	@Column(name = "database", nullable = false)	
	private String database;
	
	@Column(name = "type", nullable = false)	
	private String type;
	
	@Column(name = "description", nullable = false)	
	private String description;
}
