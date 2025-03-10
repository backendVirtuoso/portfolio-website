package com.example.portfolio.dto;

import com.example.portfolio.entity.About;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AboutDTO {
    private long id;
    private String title;
    private String content;
    private String imgUrl;

    public AboutDTO(About about) {
        this.id = about.getId();
        this.title = about.getTitle();
        this.content = about.getContent();
        this.imgUrl = about.getImgUrl();
    }
}
