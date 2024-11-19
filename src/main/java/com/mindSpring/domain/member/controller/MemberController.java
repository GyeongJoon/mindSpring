package com.mindSpring.domain.member.controller;

import com.mindSpring.domain.member.dto.LoginRequestDto;
import com.mindSpring.domain.member.dto.SignupRequestDto;
import com.mindSpring.domain.member.dto.MemberResponseDto;
import com.mindSpring.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController implements MemberControllerSwagger{

    private final MemberService memberService;

    // 회원가입
    @Override
    @PostMapping("/auth/signup")
    public ResponseEntity<String> createMember (@RequestBody SignupRequestDto signupRequestDto) {
        memberService.createMember(signupRequestDto);
        return ResponseEntity.ok("회원가입 되었습니다.");
    }

    // 로그인
    @Override
    @PostMapping("/auth/login")
    public ResponseEntity<String> loginMember (@RequestBody LoginRequestDto loginRequestDto) {
        memberService.login(loginRequestDto);
        return ResponseEntity.ok("로그인 되었습니다.");
    }

    // 프로필
    @Override
    @GetMapping("/member/{memberId}/profile")
    public ResponseEntity<MemberResponseDto> getMemberId(@PathVariable("memberId") Long memberId) {
        MemberResponseDto responseDto = memberService.getMemberId(memberId);
        return ResponseEntity.ok(responseDto);
    }


}