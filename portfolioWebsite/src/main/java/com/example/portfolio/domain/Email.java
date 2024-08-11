package com.example.portfolio.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email {
	private String to;
    private String subject;
    private String body;
}
