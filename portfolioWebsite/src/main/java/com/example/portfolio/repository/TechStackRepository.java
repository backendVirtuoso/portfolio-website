package com.example.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.portfolio.domain.TechStack;

public interface TechStackRepository extends JpaRepository<TechStack, Integer> {

}
