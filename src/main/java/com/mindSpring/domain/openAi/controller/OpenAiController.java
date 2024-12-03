package com.mindSpring.domain.openAi.controller;

import com.mindSpring.common.ResponseMessage;
import com.mindSpring.domain.openAi.dto.OpenAiRequestDto;
import com.mindSpring.domain.openAi.dto.OpenAiResponseDto;
import com.mindSpring.domain.openAi.service.OpenAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ResponseMessage<Object>> createOpenAi(@PathVariable("memberId") Long memberId,
                                                        @PathVariable("categoryId") Long categoryId,
                                                        @PathVariable("worryId") Long worryId,
                                                        @RequestBody OpenAiRequestDto openAiRequestDto) {
        OpenAiResponseDto aiAnswer = openAiService.createAiAnswer(memberId, categoryId, worryId, openAiRequestDto);

        ResponseMessage<Object> response = new ResponseMessage<>(
                "success",
                "AI답변 등록 성공",
                aiAnswer
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // AiAnswer 조회
    @Override
    @GetMapping("/{openAiId}")
    public ResponseEntity<ResponseMessage<Object>> getOpenAi(@PathVariable("memberId") Long memberId,
                                                       @PathVariable("categoryId") Long categoryId,
                                                       @PathVariable("worryId") Long worryId,
                                                       @PathVariable("openAiId") Long openAiId) {
        OpenAiResponseDto aiAnswer = openAiService.getAiAnswer(memberId, categoryId, worryId, openAiId);

        ResponseMessage<Object> response = new ResponseMessage<>(
                "success",
                "AI답변 조회 성공",
                aiAnswer
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
