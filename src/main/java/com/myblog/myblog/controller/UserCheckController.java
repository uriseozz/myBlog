package com.myblog.myblog.controller;

import com.myblog.myblog.dto.ValidCheckDto;
import com.myblog.myblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserCheckController {

    private final UserService userService;

    // 회원 가입 요청 처리 (중복 체크)
    @PostMapping("/user/signup")
    @ResponseBody
    public Map<String, String> registerUser(@RequestBody ValidCheckDto requestDto) {

        // 아이디 중복 체크 + 아이디 유효성 체크
        String idCheck = "";
        if (userService.checkup(requestDto)) {
            idCheck = "중복된 아이디입니다.";
        } else {
            if (!userService.validUsername(requestDto)) {
                idCheck = "3~12자의 영문 및 숫자로 입력해주세요.";
            }
        }

        // 비밀번호 유효성 체크
        String pwCheck = "";
        String id = requestDto.getUsername();
        String pw = requestDto.getPassword();
        if (userService.validPassword(requestDto)) {
        } else {
            pwCheck = "4~12자의 영문 및 숫자로 입력해주세요.";
        }

        // 비밀번호 동일하게 입력했는지 여부 체크
        String pwCheck2 = "";
        String pw2 = requestDto.getPassword();
        if (userService.checkPasswordEqual(requestDto)) {
        } else {
            pwCheck2 = "비밀번호가 일치하지 않습니다. 다시 확인해주세요.";
        }

        // 체크 결과와 메시지를 map에 담기
        Map<String, String> result = new HashMap<>();
        result.put("idCheck", idCheck);
        result.put("pwCheck", pwCheck);
        result.put("pwCheck2", pwCheck2);

        // 모든 검사가 통과했을 경우 회원가입 성공 시키고, 하나라도 통과하지 못하면 실패 넘기기
        if (idCheck.equals("") && pwCheck.equals("") && pwCheck2.equals("")) {
            result.put("result", "Success");
            userService.registerUser(requestDto);
        } else {
            result.put("result", "Fail");
        }
        return result;
    }
}
