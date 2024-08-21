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
            	Map<String, Object> naverResponse = (Map<String, Object>) attributes.get("response");
                email = (String) naverResponse.get("email");
                name = (String) naverResponse.get("name");
                break;
            case "kakao":
            	Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
                email = (String) kakaoAccount.get("email");
                name = (String) ((Map<String, Object>) attributes.get("properties")).get("nickname");
                break;
            default:
                throw new IllegalArgumentException("지원하지 않는 제공자입니다: " + provider);
        }

        UserTable user = userRepository.findByEmail(email)
                .map(entity -> entity.update(name)) // 업데이트 호출
                .orElse(UserTable.builder()
                        .email(email)
                        .name(name)
                        .provider(provider)
                        .build());

        return userRepository.save(user);
    }
}
