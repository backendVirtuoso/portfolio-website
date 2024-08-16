package com.example.portfolio.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.portfolio.config.jwt.TokenProvider;
import com.example.portfolio.domain.UserTable;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {
    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    public String createNewAccessToken(String refreshToken) {
        if(!tokenProvider.validToken(refreshToken)) {
            throw new IllegalArgumentException("Unexpected token");
        }

        Integer userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        UserTable user = userService.findById(userId);

        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }
}