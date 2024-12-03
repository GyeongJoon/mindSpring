package com.mindSpring.domain.openAi.controller;

import com.mindSpring.domain.openAi.dto.OpenAiRequestDto;
import com.mindSpring.domain.openAi.dto.OpenAiResponseDto;
import com.mindSpring.domain.openAi.service.OpenAiService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member/{memberId}/category/{categoryId}/worry/{worryId}/openAi")
public class OpenAiController implements OpenAiControllerSwagger {

    private final OpenAiService openAiService;

    // AiAnswer 등록
    @Override
    @PostMapping
    public ResponseEntity<String> createOpenAi(@PathVariable("memberId") Long memberId,
                                               @PathVariable("categoryId") Long categoryId,
                                               @PathVariable("worryId") Long worryId,
                                               @RequestBody OpenAiRequestDto openAiRequestDto) {
        OpenAiResponseDto aiAnswer = openAiService.createAiAnswer(memberId, categoryId, worryId, openAiRequestDto);
        return ResponseEntity.ok(aiAnswer + "저장");
    }

    // AiAnswer 조회
    @Override
    @GetMapping("/{openAiId}")
    public ResponseEntity<OpenAiResponseDto> getOpenAi(@PathVariable("memberId") Long memberId,
                                                       @PathVariable("categoryId") Long categoryId,
                                                       @PathVariable("worryId") Long worryId,
                                                       @PathVariable("openAiId") Long openAiId) {
        OpenAiResponseDto aiAnswer = openAiService.getAiAnswer(memberId, categoryId, worryId, openAiId);
        return ResponseEntity.ok(aiAnswer);
    }
}
