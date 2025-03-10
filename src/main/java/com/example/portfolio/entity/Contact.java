package com.example.portfolio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "addr", nullable = false)
    private String addr;

    @Column(name = "tel", nullable = false)
    private String tel;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "open_hours", nullable = false)
    private String openHours;

    private boolean isActive;
}
