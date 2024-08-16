package com.example.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.portfolio.domain.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer> {
    Optional<RefreshToken> findByUserId(Integer userId);
    Optional<RefreshToken> findByRefreshToken(String refreshToken);

    void deleteByUserId(Long userId);
}