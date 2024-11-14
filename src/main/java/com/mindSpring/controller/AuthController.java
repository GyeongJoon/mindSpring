package com.mindSpring.controller;

import com.mindSpring.domain.dto.LoginRequestDto;
import com.mindSpring.domain.dto.MemberResponseDto;
import com.mindSpring.domain.dto.SignupRequestDto;
import com.mindSpring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    public final MemberService memberService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<String> createMember(@RequestBody SignupRequestDto signupRequestDto) {
        MemberResponseDto member = memberService.createMember(signupRequestDto);
        return ResponseEntity.ok(member.getName() + "님이 회원가입 되었습니다.");
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto) {
        MemberResponseDto login = memberService.login(loginRequestDto);
        return ResponseEntity.ok(login.getName() + "님이 로그인 되었습니다.");
    }

    // 로그아웃
    @PostMapping("/logout")

}
