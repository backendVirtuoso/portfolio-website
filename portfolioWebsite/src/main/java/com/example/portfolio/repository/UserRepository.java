package com.example.portfolio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.portfolio.domain.UserTable;

public interface UserRepository extends JpaRepository<UserTable, Integer> { 
	Optional<UserTable> findByUserId(String userId);
	Optional<UserTable> findByEmail(String email);
	boolean existsByUserId(String userId); // 아이디 존재 여부 확인
}