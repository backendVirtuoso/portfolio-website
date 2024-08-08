package com.example.portfolio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.portfolio.domain.TechStack;

public interface TechStackRepository extends JpaRepository<TechStack, Integer> {
	Optional<TechStack> findById(Integer id);
}
