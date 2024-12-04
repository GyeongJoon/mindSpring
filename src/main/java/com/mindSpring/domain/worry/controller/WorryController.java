package com.mindSpring.domain.worry.controller;

import com.mindSpring.common.ResponseMessage;
import com.mindSpring.domain.worry.dto.WorryRequestDto;
import com.mindSpring.domain.worry.dto.WorryResponseDto;
import com.mindSpring.domain.worry.service.WorryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member/{memberId}/category/{categoryId}/worry")
public class WorryController implements WorryControllerSwagger{

    private final WorryService worryService;

    // 고민 입력
    @Override
    @PostMapping
    public ResponseEntity<ResponseMessage<Object>> createWorry(@PathVariable("memberId") Long memberId,
                                                       @PathVariable("categoryId") Long categoryId,
                                                       @RequestBody WorryRequestDto worryRequestDto) {
        WorryResponseDto worry = worryService.createWorry(memberId, categoryId, worryRequestDto);

        ResponseMessage<Object> response = new ResponseMessage<>(
                "success",
                "고민 등록 성공",
                worry
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 고민 조회
    @Override
    @GetMapping("{worryId}")
    public ResponseEntity<ResponseMessage<Object>> getWorry(@PathVariable("memberId") Long memberId,
                                                     @PathVariable("categoryId") Long categoryId,
                                                     @PathVariable("worryId") Long worryId) {
        WorryResponseDto worry = worryService.getWorry(memberId, categoryId, worryId);

        ResponseMessage<Object> response = new ResponseMessage<>(
                "success",
                "고민 조회 성공",
                worry
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 고민 목록 보기
    @Override
    @GetMapping
    public ResponseEntity<ResponseMessage<Object>> getWorries(@PathVariable("memberId") Long memberId,
                                                             @PathVariable("categoryId") Long categoryId,
                                                             @RequestParam int page,
                                                             @RequestParam int size) {
        Page<WorryResponseDto> worryPage = worryService.getWorryPage(memberId, categoryId, page, size);

        ResponseMessage<Object> response = new ResponseMessage<>(
                "success",
                "고민 목록 조회 성공",
                worryPage
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
