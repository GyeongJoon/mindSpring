package com.mindSpring.domain.member.controller;

import com.mindSpring.common.ResponseMessage;
import com.mindSpring.domain.member.dto.LoginRequestDto;
import com.mindSpring.domain.member.dto.SignupRequestDto;
import com.mindSpring.domain.member.dto.MemberResponseDto;
import com.mindSpring.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController implements MemberControllerSwagger{

    private final MemberService memberService;

    // 회원가입
    @Override
    @PostMapping(value = "/auth/signup")
    public ResponseEntity<ResponseMessage<Object>> createMember(@RequestBody SignupRequestDto signupRequestDto) {
        MemberResponseDto member = memberService.createMember(signupRequestDto);

        // API 응답 메시지 생성
        ResponseMessage<Object> response = new ResponseMessage<>(
                "success",
                "회원가입 성공",
                member
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 로그인
    @Override
    @PostMapping("/auth/login")
    public ResponseEntity<ResponseMessage<Object>> loginMember (@RequestBody LoginRequestDto loginRequestDto) {
        MemberResponseDto login = memberService.login(loginRequestDto);

        // API 응답 메시지 생성
        ResponseMessage<Object> response = new ResponseMessage<>(
                "success",
                "로그인 성공",
                login
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 회원 조회(프로필)
    @Override
    @GetMapping("/member/{memberId}/profile")
    public ResponseEntity<ResponseMessage<Object>> getMemberId(@PathVariable("memberId") Long memberId) {
        MemberResponseDto responseDto = memberService.getMemberId(memberId);

        // API 응답 메시지 생성
        ResponseMessage<Object> response = new ResponseMessage<>(
                "success",
                "프로필 조회 성공",
                responseDto
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}