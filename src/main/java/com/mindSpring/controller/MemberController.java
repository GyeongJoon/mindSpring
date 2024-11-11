package com.mindSpring.controller;

import com.mindSpring.domain.dto.MemberRequestDto;
import com.mindSpring.domain.dto.MemberResponseDto;
import com.mindSpring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class MemberController {

    public final MemberService memberService;

    // 회원 조회
    @GetMapping("/profile/{memberId}")
    public ResponseEntity<MemberResponseDto> getMemberId(@PathVariable Long memberId) {
        MemberResponseDto responseDto = memberService.getMemberId(memberId);
        return ResponseEntity.ok(responseDto);
    }

    // 회원 등록
    @PostMapping("/signup")
    public ResponseEntity<String> createMember(@RequestBody MemberRequestDto memberRequestDto) {
        MemberResponseDto member = memberService.createMember(memberRequestDto);
        return ResponseEntity.ok(member.getName() + "님이 회원가입 되었습니다.");
    }

    // 회원 수정

    // 회원 삭제
}
