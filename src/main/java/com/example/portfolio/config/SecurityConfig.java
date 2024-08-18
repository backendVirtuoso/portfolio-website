package com.example.portfolio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.portfolio.config.jwt.TokenProvider;
import com.example.portfolio.config.oauth.OAuth2AuthorizationRequestBasedOnCookieRepository;
import com.example.portfolio.config.oauth.OAuth2SuccessHandler;
import com.example.portfolio.config.oauth.OAuth2UserCustomService;
import com.example.portfolio.repository.RefreshTokenRepository;
import com.example.portfolio.service.UserService;

import groovy.lang.Lazy;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity	// 스프링 시큐리티 필터가 스프링 필터체인에 등록이 된다.
public class SecurityConfig {
	
	private final OAuth2UserCustomService oAuth2UserCustomService;
    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
			.requestMatchers(new AntPathRequestMatcher("/user/delete")).authenticated()
			.requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
			.csrf(csrf -> csrf.ignoringRequestMatchers(new AntPathRequestMatcher("/home/**")))
			.headers((headers) -> headers.addHeaderWriter(new XFrameOptionsHeaderWriter(
	                    XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
	        .formLogin((formLogin) -> formLogin
                .loginPage("/user/login")
                .defaultSuccessUrl("/"))
	        .oauth2Login(oauth2 -> oauth2
                    .loginPage("/user/login")
                    .authorizationEndpoint(authorizationEndpoint -> authorizationEndpoint.authorizationRequestRepository(oAuth2AuthorizationRequestBasedOnCookieRepository()))
                    .userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint.userService(oAuth2UserCustomService))
                    )
	        .logout((logout) -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true));
		
		return http.build();
	}
	
	@Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public TokenAuthenticationFilter tokenAuthenticationFilter() {
        return new TokenAuthenticationFilter(tokenProvider);
    }

    @Bean
    public OAuth2AuthorizationRequestBasedOnCookieRepository oAuth2AuthorizationRequestBasedOnCookieRepository() {
        return new OAuth2AuthorizationRequestBasedOnCookieRepository();
    }
    
	
}