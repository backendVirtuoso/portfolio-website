package com.example.portfolio.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Value("${file.add.about}")
    private String aboutPhotoAdd;

    @Value("${file.add.portfolio}")
    private String portfolioPhotoAdd;
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/about/**").addResourceLocations(aboutPhotoAdd);
        registry.addResourceHandler("/portfolio/**").addResourceLocations(portfolioPhotoAdd);
    }
}
