package com.example.portfolio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.portfolio.domain.SiteUser;

public interface UserRepository extends JpaRepository<SiteUser, Integer> { 
	Optional<SiteUser> findByUserId(String userId);
}