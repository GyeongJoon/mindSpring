package com.mindSpring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members/{memberId}")
public class WorryController {

    // 카테고리 목록 조회
    @GetMapping("/categories")

    // 고민 생성
    @PostMapping("/worries")

    // 사용자의 고민 목록 조회
    @GetMapping("/reviews")

    // 특정 고민 상세 조회
    @PostMapping("/reviews")

    // 고민 수정
    @PutMapping("/reviews/{reviewId}")

    // 고민 삭제
    @DeleteMapping("/reviews/{reviewId}")
}
