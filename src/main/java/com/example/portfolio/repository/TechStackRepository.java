package com.example.portfolio.repository;

import com.example.portfolio.entity.TechStack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TechStackRepository extends JpaRepository<TechStack, Long> {
    List<TechStack> findAllByIsActive(@Param("isActive") boolean isActive);
} 