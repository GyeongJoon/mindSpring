package com.mindSpring.domain.review.controller;

import com.mindSpring.domain.review.dto.ReviewRequestDto;
import com.mindSpring.domain.review.dto.ReviewResponseDto;
import com.mindSpring.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member/{memberId}/counselor/{counselorId}/review")
public class ReviewController implements ReviewControllerSwagger{

    private final ReviewService reviewService;

    // 리뷰 작성
    @Override
    @PostMapping
    public ResponseEntity<String> createReview (@PathVariable("memberId") Long memberId,
                                                @PathVariable("counselorId") Long counselorId,
                                                @RequestBody ReviewRequestDto reviewRequestDto) {

        reviewService.createReview(memberId, counselorId, reviewRequestDto);
        return ResponseEntity.ok("리뷰가 등록되었습니다.");
    }


    // 리뷰 조회
    @Override
    @GetMapping("/{reviewId}")
    public ResponseEntity<ReviewResponseDto> getReview (@PathVariable("memberId") Long memberId,
                                                        @PathVariable("counselorId") Long counselorId,
                                                        @PathVariable("reviewId") Long reviewId) {

        ReviewResponseDto review = reviewService.getReview(memberId, counselorId, reviewId);
        return ResponseEntity.ok(review);
    }


    // 리뷰 전체 조회
    @Override
    @GetMapping
    public ResponseEntity<List<ReviewResponseDto>> getReviews (@PathVariable("memberId") Long memberId,
                                                               @PathVariable("counselorId") Long counselorId){

        List<ReviewResponseDto> reviews = reviewService.getReviews(memberId, counselorId);
        return ResponseEntity.ok(reviews);
    }

}
