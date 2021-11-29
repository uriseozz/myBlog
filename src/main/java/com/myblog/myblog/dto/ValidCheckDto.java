package com.myblog.myblog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ValidCheckDto {

    // 회원가입 시 요구조건 Dto
    private String username;
    private String password;
    private String password2;

    public ValidCheckDto(String username, String password, String password2) {
        this.username = username;
        this.password = password;
        this.password2 = password2;
    }
}