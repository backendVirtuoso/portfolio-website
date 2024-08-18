package com.example.portfolio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.portfolio.domain.About;

public interface AboutRepository extends JpaRepository<About, Integer> {
	Optional<About> findById(Integer id);
}
