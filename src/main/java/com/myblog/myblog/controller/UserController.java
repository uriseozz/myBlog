package com.myblog.myblog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.myblog.myblog.dto.UserRequestDto;
import com.myblog.myblog.repository.UserRepository;
import com.myblog.myblog.security.UserDetailsImpl;
import com.myblog.myblog.service.KakaoUserService;
import com.myblog.myblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final KakaoUserService kakaoUserService;


    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            model.addAttribute("user", userDetails.getUser().getUsername());
        } else {
            model.addAttribute("user", null);
        }
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            model.addAttribute("user", userDetails.getUser().getUsername());
        } else {
            model.addAttribute("loginUsername", null);
        }

        model.addAttribute("requestDto", new UserRequestDto());
        return "signup";
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(@RequestBody UserRequestDto userRequestDto) {
        userService.registerUser(userRequestDto);
        return "login";
    }

    // 카카오로그인
    @GetMapping("/user/kakao/callback")
    public String kakaoLogin(@RequestParam String code) throws JsonProcessingException {
        kakaoUserService.kakaoLogin(code);
        return "redirect:/";
    }

}
