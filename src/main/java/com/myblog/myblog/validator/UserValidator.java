package com.myblog.myblog.validator;

import com.myblog.myblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class UserValidator {

    public static void validateUserRegister(
            String username,
            String password,
            String password2
    ){
        String patternId = "^[a-zA-Z0-9]{3,12}$"; //아이디: 영대소문,숫자 3-12이내
        String patternpw = "^[a-zA-Z0-9]{4,12}$"; //비밀번호: 영대소문,숫자 4-12이내

        //아이디 검사
        if(username == null || !Pattern.matches(patternId, username)){
            throw new IllegalArgumentException("아이디는 숫자와 영문 대소문자를 이용해 3~12자로 입력해주세요.");
        }

        //비밀번호 확인
        if (password == null || !Pattern.matches(patternpw, password)) {
            System.out.println(password);
            throw new IllegalArgumentException("비밀번호는 숫자와 영문 대소문자를 이용해 4~12자로 입력해주세요.");
        }

        if (!password.equals(password2)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }
}
