package com.mindSpring.domain.aiAnswer.controller;

import com.mindSpring.domain.aiAnswer.dto.AiAnswerResponseDto;
import com.mindSpring.domain.aiAnswer.service.AiAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member/{memberId}/category/{categoryId}/worry/{worryId}/ai-answer")
public class AiAnswerController implements AiAnswerControllerSwagger {

    private final AiAnswerService aiAnswerService;

    @GetMapping("/{aiAnswerId}")
    @Override
    public ResponseEntity<AiAnswerResponseDto> getAiAnswer(@PathVariable("memberId") Long memberId,
                                                           @PathVariable("categoryId") Long categoryId,
                                                           @PathVariable("worryId") Long worryId,
                                                           @PathVariable("aiAnswerId") Long aiAnswerId) {
        AiAnswerResponseDto response = aiAnswerService.getAiAnswer(memberId, categoryId, worryId, aiAnswerId);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @Override
    public ResponseEntity<String> createAiAnswer(@PathVariable("memberId") Long memberId,
                                                 @PathVariable("categoryId") Long categoryId,
                                                 @PathVariable("worryId") Long worryId) {
        AiAnswerResponseDto response = aiAnswerService.createAiAnswer(memberId, categoryId, worryId);
        return ResponseEntity.ok(response.getResponse());
    }
}