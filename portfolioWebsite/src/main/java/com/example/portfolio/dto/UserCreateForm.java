package com.example.portfolio.dto;

import com.example.portfolio.domain.UserTable;
import com.example.portfolio.domain.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
	
	@Size(min = 3, max = 25)
	@NotEmpty(message = "사용자 ID는 필수 항목입니다.")
	private String userId;
	
	@NotEmpty(message = "이름은 필수 항목입니다.")
	private String name;

	@Size(min=8, max=12)
	@Pattern(regexp="^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*\\W).{8,12}$", message="비밀번호는 영문, 숫자, 특수문자를 조합하여 8~12자로 입력해주세요.")
	@NotEmpty(message="비밀번호 영문, 숫자, 특수문자 조합 8~12자")
	private String password1;
	
	@NotEmpty(message="비밀번호 다시 입력해주세요")
	private String password2;
	
	@NotEmpty(message = "이메일은 필수 항목입니다.")
	@Email(message = "올바른 이메일 주소를 입력해주세요.")
	private String email;	
	
}
