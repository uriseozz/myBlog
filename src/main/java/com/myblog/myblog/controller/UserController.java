package com.myblog.myblog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.myblog.myblog.domain.User;
import com.myblog.myblog.dto.UserRequestDto;
import com.myblog.myblog.repository.UserRepository;
import com.myblog.myblog.security.UserDetailsImpl;
import com.myblog.myblog.service.KakaoUserService;
import com.myblog.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;
    private final KakaoUserService kakaoUserService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService, KakaoUserService kakaoUserService) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.kakaoUserService = kakaoUserService;
    }

    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if(userDetails == null){
            model.addAttribute("user","null");
        }else{

            model.addAttribute("user",userDetails.getUser().getUsername());
        }
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if(userDetails == null){
            model.addAttribute("user","null");
        }else{
            model.addAttribute("user",userDetails.getUser().getUsername());
        }
        model.addAttribute("requestDto", new UserRequestDto());
        return "signup";
    }

    @GetMapping("/user/kakao/callback")
    public String kakaoLogin(@RequestParam String code) throws JsonProcessingException {
        kakaoUserService.kakaoLogin(code);
        return "redirect:/";
    }

    @PostMapping("/user/signup")
    public String registerUser(Model model, @Valid @ModelAttribute("requestDto") UserRequestDto requestDto, BindingResult bindingResult){

        // 회원 ID 중복 확인
        Optional<User> found = userRepository.findByUsername(requestDto.getUsername()); // Optional을 쓰면 null을 받을 수 있다.
        if(found.isPresent()){ // found가 null이 아니면 true를 출력한다.
            FieldError fieldError = new FieldError("requestDto", "username", "이미 존재하는 ID입니다.");
            bindingResult.addError(fieldError);
        }

        if(!requestDto.getPassword().equals(requestDto.getCheckpw())){
            FieldError fieldError = new FieldError("requestDto","checkpw","암호가 일치하지 않습니다.");
            bindingResult.addError(fieldError);
        }

        if (requestDto.getPassword().indexOf(requestDto.getUsername()) != -1) { // indexof가 -1이면 안에 포함이 안되어있음
            FieldError fieldError = new FieldError("requestDto", "password", "비밀번호에 닉네임과 같은값을 넣을수 없습니다.");
            bindingResult.addError(fieldError);
        }

        if(bindingResult.hasErrors()){
            model.addAttribute("user","null");
            return "signup";
        }

        userService.registerUser(requestDto);
        return "redirect:/user/login";

    }
}
