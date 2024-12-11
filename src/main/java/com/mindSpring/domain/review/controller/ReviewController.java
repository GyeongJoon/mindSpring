package com.mindSpring.domain.review.controller;

import com.mindSpring.common.ResponseMessage;
import com.mindSpring.domain.review.dto.ReviewRequestDto;
import com.mindSpring.domain.review.dto.ReviewResponseDto;
import com.mindSpring.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member/{memberId}")
public class ReviewController implements ReviewControllerSwagger{

    private final ReviewService reviewService;

    // 리뷰 등록
    @Override
    @PostMapping("/counselor/{counselorId}/review")
    public ResponseEntity<ResponseMessage<Object>> createReview (@PathVariable("memberId") Long memberId,
                                                         @PathVariable("counselorId") Long counselorId,
                                                         @RequestBody ReviewRequestDto reviewRequestDto) {

        ReviewResponseDto review = reviewService.createReview(memberId, counselorId, reviewRequestDto);

        ResponseMessage<Object> response = new ResponseMessage<>(
                "success",
                "리뷰 등록 성공",
                review
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    // 리뷰 조회
    @Override
    @GetMapping("review/{reviewId}")
    public ResponseEntity<ResponseMessage<Object>> getReview (@PathVariable("memberId") Long memberId,
                                                        @PathVariable("reviewId") Long reviewId) {

        ReviewResponseDto review = reviewService.getReview(memberId, reviewId);

        ResponseMessage<Object> response = new ResponseMessage<>(
                "success",
                "리뷰 조회 성공",
                review
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    // 상담사별 리뷰 조회
    @Override
    @GetMapping("counselor/{counselorId}/review")
    public ResponseEntity<ResponseMessage<Object>> getReviews (@PathVariable("memberId") Long memberId,
                                                               @PathVariable("counselorId") Long counselorId){

        List<ReviewResponseDto> reviews = reviewService.getReviews(memberId, counselorId);

        ResponseMessage<Object> response = new ResponseMessage<>(
                "success",
                "상담사별 리뷰 조회 성공",
                reviews
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
