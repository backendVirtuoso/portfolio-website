package com.example.portfolio.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.portfolio.domain.UserTable;
import com.example.portfolio.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /** 새로운 사용자를 생성하고 데이터베이스에 저장합니다. */
    public UserTable create(String userId, String email, String password, String name) {
        if (isUsernameTaken(userId)) {
            throw new RuntimeException("사용자 아이디가 이미 존재합니다.");
        }
        
        UserTable user = new UserTable();
        user.setUserId(userId);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setName(name);
        return this.userRepository.save(user);
    }
    
    /** 주어진 사용자 ID가 이미 존재하는지 확인합니다. */
    public boolean isUsernameTaken(String userId) {
        return userRepository.findByUserId(userId).isPresent();
    }
    
    /** 주어진 사용자 ID에 대한 사용자 정보를 반환합니다. */
    public UserTable getUser(String userId) {
        Optional<UserTable> siteUser = this.userRepository.findByUserId(userId);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new RuntimeException("사용자 아이디를 찾을 수 없습니다.");
        }
    }
    
    /** 사용자 정보를 업데이트합니다. 비밀번호가 제공된 경우 비밀번호를 암호화하여 업데이트합니다. */
    public void updateUser(UserTable siteUser, String newPassword, String name) {
        if (newPassword != null && !newPassword.isEmpty()) {
            siteUser.setPassword(passwordEncoder.encode(newPassword));
        }
        siteUser.setName(name);
        this.userRepository.save(siteUser);
    }
    
    /** 현재 비밀번호와 사용자 비밀번호가 일치하는지 확인합니다. */
    public boolean checkPassword(UserTable user, String currentPassword) {
        return passwordEncoder.matches(currentPassword, user.getPassword());
    }
    
    /** 주어진 사용자 ID가 사용 가능한지 확인합니다. */
    public boolean isUserIdAvailable(String userId) {
    	return !userRepository.findByUserId(userId).isPresent();
    }
    
    /** 주어진 사용자 ID에 해당하는 사용자를 삭제합니다. */
    @Transactional
    public void deleteUser(String userId) {
        UserTable user = getUser(userId); // 사용자 확인
        userRepository.delete(user);
    }
    
    public UserTable findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }
    
    public UserTable findById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }
}
