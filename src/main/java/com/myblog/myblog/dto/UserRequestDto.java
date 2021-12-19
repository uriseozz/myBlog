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

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String password2;

    private Long kakaoId;
}

