package com.example.portfolio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class About {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "img_url", nullable = false)
    private String imgUrl;

    private boolean isActive;

    public About(String title, String content, String imgUrl, boolean isActive) {
        this.title = title;
        this.content = content;
        this.imgUrl = imgUrl;
        this.isActive = isActive;
    }
}
