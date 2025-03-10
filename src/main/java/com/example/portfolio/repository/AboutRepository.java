package com.example.portfolio.repository;

import com.example.portfolio.entity.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AboutRepository extends JpaRepository<About, Long> {
    List<About> findAllByIsActive(@Param("isActive") boolean isActive);
}
