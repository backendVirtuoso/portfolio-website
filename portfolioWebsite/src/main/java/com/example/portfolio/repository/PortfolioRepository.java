package com.example.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.portfolio.domain.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {
	List<Portfolio> findAll();
}
