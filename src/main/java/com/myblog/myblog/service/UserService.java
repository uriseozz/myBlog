package com.myblog.myblog.service;

import com.myblog.myblog.domain.User;
import com.myblog.myblog.dto.UserRequestDto;
import com.myblog.myblog.dto.ValidCheckDto;
import com.myblog.myblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void registerUser(ValidCheckDto requestDto) {
        String username = requestDto.getUsername();

        // 패스워드 암호화
        String password = passwordEncoder.encode(requestDto.getPassword());

        User user = new User(username, password);
        userRepository.save(user);
    }

    // 유효성 체크
    // 아이디 중복 확인
    public Boolean checkup(ValidCheckDto checkDto) {
        String username = checkDto.getUsername();
        Optional<User> found = userRepository.findByUsername(username);
        return found.isPresent();
    }

    // 아이디 유효성 체크
    public Boolean validUsername(ValidCheckDto checkDto) {
        String username = checkDto.getUsername();
        return Pattern.matches("^[0-9a-zA-Z]{3,12}", username);
    }

    // 비밀번호 유효성 체크
    public Boolean validPassword(ValidCheckDto checkDto) {
        String password = checkDto.getPassword();
        if (password.contains(checkDto.getUsername())) {
            return false;
        } else {
            return Pattern.matches("^[0-9a-zA-Z]{4,12}", password);
        }
    }

    // 비밀번호 동일 여부 체크
    public Boolean checkPasswordEqual(ValidCheckDto checkDto) {
        return checkDto.getPassword().equals(checkDto.getPassword2());
    }

}