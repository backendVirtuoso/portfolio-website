package com.example.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.portfolio.domain.About;

public interface AboutRepository extends JpaRepository<About, Integer> {

}
