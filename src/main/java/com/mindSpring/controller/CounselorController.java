package com.mindSpring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members/{memberId}/counselors")
public class CounselorController {

    // 상담사 목록 조회
    @GetMapping

    // 상담사 상세 정보
    @GetMapping("/{counselorId")

    // 상담사 리뷰 목록
    @GetMapping("/{counselorId/reviews")

    // 상담사 리뷰 작성
    @PostMapping("/{counselorId/reviews")

    // 리뷰 수정
    @PutMapping("/{counselorId/reviews/{reviewId}")

    // 리뷰 삭제
    @DeleteMapping("/{counselorId/reviews/{reviewId}")
}
