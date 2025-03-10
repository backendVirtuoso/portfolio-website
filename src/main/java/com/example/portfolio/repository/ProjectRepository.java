package com.example.portfolio.repository;

import com.example.portfolio.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findAllByIsActive(@Param("isActive") boolean isActive);

    Optional<Project> findById(@Param("id") Long id);
} 