package com.mindSpring.domain.worry.controller;

import com.mindSpring.domain.worry.dto.WorryRequestDto;
import com.mindSpring.domain.worry.dto.WorryResponseDto;
import com.mindSpring.domain.worry.entity.Worry;
import com.mindSpring.domain.worry.service.WorryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<String> createWorry(@PathVariable("memberId") Long memberId,
                                              @PathVariable("categoryId") Long categoryId,
                                              @RequestBody WorryRequestDto worryRequestDto) {
        WorryResponseDto worry = worryService.createWorry(memberId, categoryId, worryRequestDto);
        return ResponseEntity.ok("고민이 등록되었습니다.");
    }

    // 고민 조회
    @Override
    @GetMapping("{worryId}")
    public ResponseEntity<WorryResponseDto> getWorry(@PathVariable("memberId") Long memberId,
                                                     @PathVariable("categoryId") Long categoryId,
                                                     @PathVariable("worryId") Long worryId) {
        WorryResponseDto worry = worryService.getWorry(memberId, categoryId, worryId);
        return ResponseEntity.ok(worry);
    }

    // 고민 목록 보기
    @GetMapping
    public ResponseEntity<Page<WorryResponseDto>> getWorries(@PathVariable("memberId") Long memberId,
                                                             @PathVariable("categoryId") Long categoryId,
                                                             @RequestParam int page,
                                                             @RequestParam int size) {
        Page<WorryResponseDto> worryPage = worryService.getWorryPage(memberId, categoryId, page, size);
        return ResponseEntity.ok(worryPage);
    }
}
