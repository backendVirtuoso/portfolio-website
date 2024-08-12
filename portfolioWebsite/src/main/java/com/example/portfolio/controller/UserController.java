package com.example.portfolio.controller;

import java.io.IOException;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.portfolio.domain.SiteUser;
import com.example.portfolio.dto.UserCreateForm;
import com.example.portfolio.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
		
	@GetMapping("/signup")
	public String signup(UserCreateForm userCreateForm) {
		return "signup_form";
	}
	
	@PostMapping("/signup")
	public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
	    if (bindingResult.hasErrors()) {
	        return "signup_form";
	    }

	    // 비밀번호 일치 여부 확인
	    if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
	        bindingResult.rejectValue("password2", "passwordInCorrect", "비밀번호가 일치하지 않습니다.");
	        return "signup_form";
	    }

	    // 아이디 중복 확인
	    if (userService.isUsernameTaken(userCreateForm.getUserId())) {
	        bindingResult.rejectValue("userId", "usernameTaken", "이미 사용 중인 아이디입니다.");
	        return "signup_form";
	    }

	    // 사용자 생성
	    userService.create(userCreateForm.getUserId(), userCreateForm.getEmail(), userCreateForm.getPassword1(), userCreateForm.getName());

	    redirectAttributes.addFlashAttribute("successMessage", userCreateForm.getUserId() + "님 반갑습니다! 이제 HJH's Portfolio를 이용해보세요!!");
	    return "redirect:/";
	}


	@GetMapping("/login")
	public String login() {
	    return "login_form";
	}
	
	@GetMapping("/mypage/{userId}")
	public String mypage(Model model, @PathVariable("userId") String userId) {
		SiteUser siteUser = this.userService.getUser(userId);
		model.addAttribute("siteUser", siteUser);
		return "mypage_form";
	}
	
	@PostMapping("/mypage/{userId}")
    public String mypageUpdate(
            @ModelAttribute("siteUser") @Valid SiteUser siteUser, BindingResult bindingResult,
            @RequestParam(name = "currentPassword", required = true) String currentPassword,
            @RequestParam(name = "newpassword1", required = false) String newpassword1,
            @RequestParam(name = "newpassword2", required = false) String newpassword2,
            @PathVariable("userId") String userId, Model model) throws IOException {
	   	  
		// 폼 데이터 유효성 검사
        if (bindingResult.hasErrors()) {
            return "mypage_form"; //오류 있으면 다시 폼으로
        }

        // 현재 비밀번호가 입력되지 않았을 경우 오류메세지
        if (currentPassword == null || currentPassword.isEmpty()) {
            bindingResult.reject("currentPasswordMissing", "현재 비밀번호를 입력해주세요.");
            return "mypage_form";
        }
        
        // loginId 기반으로 현재 사용자 정보 get
        SiteUser existingUser = userService.getUser(userId);
        
        // 사용자가 존재하지 않으면 에러 페이지로
        if (existingUser == null) {
            return "error"; // Handle case where user is not found
        }

        // 현재 비밀번호가 일치하지 않을 경우 오류메세지
        if (!userService.checkPassword(existingUser, currentPassword)) {
            bindingResult.reject("currentPasswordIncorrect", "현재 비밀번호가 일치하지 않습니다.");
            return "mypage_form";
        }
        
        
        // 새 비밀번호가 입력된 경우 pw1,2 일치하는 지 확인
        if (newpassword1 != null && !newpassword1.isEmpty()) {
            if (!newpassword1.equals(newpassword2)) {
                bindingResult.reject("passwordMismatch", "새 비밀번호가 일치하지 않습니다.");
                return "mypage_form";
            }
            // 새 비번 포함 사용자 정보 업데이트
            userService.updateUser(existingUser, newpassword1, siteUser.getName());
        } else {
      	  // 새 비번 없으면 비번 제외 나머지 정보 업데이트
            userService.updateUser(existingUser, null, siteUser.getName());
        }
        
        // 성공 메시지를 모델에 추가
        model.addAttribute("successMessage", "회원 정보 수정이 정상적으로 처리됐습니다!");

        return String.format("redirect:/user/logout?logoutSuccess=true");
    }
	
	@PostMapping("/delete")
	public String deleteUser(@AuthenticationPrincipal UserDetails userDetails) {
		String loginId = userDetails.getUsername(); // 현재 로그인된 사용자의 ID 가져오기
		userService.deleteUser(loginId);
	    return "redirect:/user/logout"; // 탈퇴 후 로그아웃 처리
	}
}