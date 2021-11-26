package com.myblog.myblog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDto {

    @NotBlank(message = "아이디를 입력해주세요")
    @Pattern(regexp="^[a-zA-Z0-9]{3,12}$", message="아이디는 숫자와 영문 대소문자를 이용해 3~12자로 입력해주세요.")
    private String username;

    @Pattern(regexp="^[a-zA-Z0-9]{4,12}$", message="비밀번호는 숫자와 영문 대소문자를 이용해 4~12자로 입력해주세요.")
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;

    @NotBlank(message = "비밀번호 확인을 입력해주세요")
    private String checkpw;

    private Long kakaoId;

}

