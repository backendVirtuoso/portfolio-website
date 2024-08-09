package com.example.portfolio.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Value("${file.add.about}")
    private String aboutPotoAdd;

    @Value("${file.add.portfolio}")
    private String portfolioPotoAdd;
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        
        registry.addResourceHandler("/about/**")
        		.addResourceLocations(aboutPotoAdd);
        
        registry.addResourceHandler("/portfolio/**")
        		.addResourceLocations(portfolioPotoAdd);
    }
}
