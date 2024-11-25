package com.mindSpring.domain.counselor.controller;

import com.mindSpring.domain.counselor.dto.CounselorResponseDto;
import com.mindSpring.domain.counselor.service.CounselorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member/{memberId}/counselor")
public class CounselorController implements CounselorControllerSwagger{

    private final CounselorService counselorService;

    // 상담사 전체 조회
    @Override
    @GetMapping
    public ResponseEntity<List<CounselorResponseDto>> getCounselors(@PathVariable("memberId") Long memberId) {
        List<CounselorResponseDto> counselors = counselorService.getCounselors(memberId);
        return ResponseEntity.ok(counselors);
    }

    // 상담사 조회
    @Override
    @GetMapping("/{counselorId}")
    public ResponseEntity<CounselorResponseDto> getCounselor(@PathVariable("memberId") Long memberId, @PathVariable("counselorId") Long counselorId) {
        CounselorResponseDto counselor = counselorService.getCounselor(memberId, counselorId);
        return ResponseEntity.ok(counselor);
    }
}
