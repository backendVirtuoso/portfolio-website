package com.example.portfolio.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(unique = true)
    private String userId;

    private String password;

    private String name;

    @Column(unique = true)
    private String email;
    
    @Column(name = "nickname", unique = true)
    private String nickname;
    
    @Builder
    public UserTable(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }
    
	// update 메서드 추가
    public UserTable update(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
        return this;  // 변경된 객체를 반환
    }
    
}