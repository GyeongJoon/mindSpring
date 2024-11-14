package com.mindSpring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members/{memberId}/worries/{worryId}/ai-answer")
public class AIAnswerController {


    // AI 답변 조회
    @GetMapping

    // AI 답변 생성
    @PostMapping
}
