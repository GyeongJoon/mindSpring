package com.mindSpring.domain.counselor.controller;

import com.mindSpring.common.ResponseMessage;
import com.mindSpring.domain.counselor.dto.CounselorResponseDto;
import com.mindSpring.domain.counselor.service.CounselorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member/{memberId}/counselor")
public class CounselorController implements CounselorControllerSwagger{

    private final CounselorService counselorService;

    // 상담사 전체 조회
    @Override
    @GetMapping
    public ResponseEntity<ResponseMessage<Object>> getCounselors(@PathVariable("memberId") Long memberId) {
        List<CounselorResponseDto> counselors = counselorService.getCounselors(memberId);

        ResponseMessage<Object> response = new ResponseMessage<>(
                "success",
                "상담사 전체 조회 성공",
                counselors
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 상담사 조회
    @Override
    @GetMapping("/{counselorId}")
    public ResponseEntity<ResponseMessage<Object>> getCounselor(@PathVariable("memberId") Long memberId, @PathVariable("counselorId") Long counselorId) {
        CounselorResponseDto counselor = counselorService.getCounselor(memberId, counselorId);

        ResponseMessage<Object> response = new ResponseMessage<>(
                "success",
                "상담사 조회 성공",
                counselor
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
