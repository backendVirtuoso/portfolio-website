package com.example.portfolio.config.oauth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.example.portfolio.domain.UserTable;
import com.example.portfolio.repository.UserRepository;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class OAuth2UserCustomService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User user = super.loadUser(userRequest);
        saveOrUpdate(user, userRequest.getClientRegistration().getRegistrationId());

        return user;
    }

    private UserTable saveOrUpdate(OAuth2User oAuth2User, String provider) {
        Map<String, Object> attributes = oAuth2User.getAttributes();

        String email;
        String name;

        // 제공자에 따라 사용자 정보를 가져옴
        switch (provider) {
            case "google":
                email = (String) attributes.get("email");
                name = (String) attributes.get("name");
                break;
            case "naver":
                email = (String) attributes.get("response/email"); // Naver에서 이메일 가져오기
                name = (String) attributes.get("response/name"); // Naver에서 이름 가져오기
                break;
            case "kakao":
                email = (String) ((Map) attributes.get("kakao_account")).get("email"); // Kakao에서 이메일 가져오기
                name = (String) ((Map) attributes.get("properties")).get("nickname"); // Kakao에서 닉네임 가져오기
                break;
            default:
                throw new IllegalArgumentException("지원하지 않는 제공자입니다: " + provider);
        }

        UserTable user = userRepository.findByEmail(email)
                .map(entity -> entity.update(name, entity.getNickname())) // 업데이트 호출
                .orElse(UserTable.builder()
                        .email(email)
                        .nickname(name)
                        .provider(provider)
                        .build());

        return userRepository.save(user);
    }
}
