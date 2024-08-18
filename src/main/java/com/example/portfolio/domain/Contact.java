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
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	
	@Column(name = "addr", nullable = false)
	private String addr;
	
	@Column(name = "tel", nullable = false)
	private String tel;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "openHours", nullable = false)
	private String openHours;
	
}
