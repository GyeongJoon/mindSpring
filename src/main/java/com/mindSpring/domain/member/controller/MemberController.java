package com.mindSpring.domain.member.controller;

import com.mindSpring.domain.member.dto.LoginRequestDto;
import com.mindSpring.domain.member.dto.SignupRequestDto;
import com.mindSpring.domain.member.dto.MemberResponseDto;
import com.mindSpring.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController implements MemberControllerSwagger{

    private final MemberService memberService;

    // 회원가입
    @Override
    @PostMapping("/auth/signup")
    public ResponseEntity<Map<String, String>> createMember (@RequestBody SignupRequestDto signupRequestDto) {
        memberService.createMember(signupRequestDto);

        // JSON 형태의 메시지 생성
         Map<String, String> response = new HashMap<>();
         response.put("message", "회원가입이 성공적으로 완료되었습니다.");
        return ResponseEntity.ok(response);
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