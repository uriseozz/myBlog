package com.myblog.myblog.service;

import com.myblog.myblog.domain.User;
import com.myblog.myblog.dto.UserRequestDto;
import com.myblog.myblog.repository.UserRepository;
import com.myblog.myblog.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public String registerUser(UserRequestDto requestDto) {
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();
        String password2 = requestDto.getPassword2();

        // 회원 ID 중복 확인
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalStateException("중복된 아이디 입니다.");
        }

        // 패스워드 암호화
        String enpassword = passwordEncoder.encode(password);

        // 회원가입 유효성 검사
        UserValidator.validateUserRegister(username, password, password2);

        User user = new User(username, enpassword);
        userRepository.save(user);
        return "success";
    }
}