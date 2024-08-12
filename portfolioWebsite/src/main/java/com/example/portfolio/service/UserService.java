package com.example.portfolio.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.portfolio.domain.SiteUser;
import com.example.portfolio.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String userId, String email, String password, String name) {
        SiteUser user = new SiteUser();
        user.setUserId(userId);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setName(name);
        this.userRepository.save(user);
        return user;
    }
    
    public boolean isUsernameTaken(String userId) {
        return userRepository.findByUserId(userId).isPresent();
    }
    
    public SiteUser getUser(String userId) {
    	Optional<SiteUser> siteUser = this.userRepository.findByUserId(userId);
		if (siteUser.isPresent()) {
			return siteUser.get();
		} else {
			throw new RuntimeException("사용자 아이디를 찾을 수 없습니다.");
		}
    }
    
    public void updateUser(SiteUser siteUser, String newPassword, String name) {
		if (newPassword != null && !newPassword.isEmpty()) {
			siteUser.setPassword(passwordEncoder.encode(newPassword));
		}
		siteUser.setName(name);
		this.userRepository.save(siteUser);
	}
    
    public boolean checkPassword(SiteUser user, String currentPassword) {
		return passwordEncoder.matches(currentPassword, user.getPassword());
	}
    
    @Transactional
	public void deleteUser(String userId) {
		Optional<SiteUser> siteUser = userRepository.findByUserId(userId);
		if (siteUser.isPresent()) {
			userRepository.delete(siteUser.get());
		} else {
			throw new RuntimeException("사용자를 찾을 수 없습니다.");
		} 
	}
}
