package com.example.portfolio.domain;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

	private final String value;

	UserRole(String value) {
        this.value = value;
    }

}