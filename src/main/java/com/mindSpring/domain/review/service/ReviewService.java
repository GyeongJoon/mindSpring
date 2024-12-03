package com.mindSpring.domain.review.service;

import com.mindSpring.domain.counselor.entity.Counselor;
import com.mindSpring.domain.counselor.repository.CounselorRepository;
import com.mindSpring.domain.member.entity.Member;
import com.mindSpring.domain.member.repository.MemberRepository;
import com.mindSpring.domain.review.dto.ReviewRequestDto;
import com.mindSpring.domain.review.dto.ReviewResponseDto;
import com.mindSpring.domain.review.entity.Review;
import com.mindSpring.domain.review.mapper.ReviewMapper;
import com.mindSpring.domain.review.repository.ReviewRepository;
import com.mindSpring.exception.ErrorCode;
import com.mindSpring.exception.appException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final MemberRepository memberRepository;
    private final CounselorRepository counselorRepository;
    private final ReviewRepository reviewRepository;

    // 리뷰 등록 API
    @Transactional
    public ReviewResponseDto createReview(Long memberId, Long counselorId, ReviewRequestDto reviewRequestDto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new appException(ErrorCode.MEMBER_NOT_FOUND));
        Counselor counselor = counselorRepository.findById(counselorId)
                .orElseThrow(() -> new appException(ErrorCode.COUNSELOR_NOT_FOUND));

        Review reviewEntity = ReviewMapper.toReviewEntity(member, counselor, reviewRequestDto);
        reviewRepository.save(reviewEntity);
        return ReviewMapper.toReviewDto(reviewEntity);
    }

    // 리뷰 조회 API
    @Transactional(readOnly = true)
    public ReviewResponseDto getReview(Long memberId, Long reviewId) {
        memberRepository.findById(memberId)
                .orElseThrow(() -> new appException(ErrorCode.MEMBER_NOT_FOUND));
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new appException(ErrorCode.REVIEW_NOT_FOUND));

        return ReviewMapper.toReviewDto(review);
    }

    // 리뷰 전체 조회 API
    @Transactional(readOnly = true)
    public List<ReviewResponseDto> getReviews(Long memberId, Long counselorId) {
        memberRepository.findById(memberId)
                .orElseThrow(() -> new appException(ErrorCode.MEMBER_NOT_FOUND));
        counselorRepository.findById(counselorId)
                .orElseThrow(() -> new appException(ErrorCode.COUNSELOR_NOT_FOUND));

        // 상담사별 리뷰 조회
        List<Review> reviews = reviewRepository.findByCounselorId(counselorId);

        if (reviews.isEmpty()) {
            throw new appException(ErrorCode.REVIEW_NOT_FOUND); // 리뷰가 없을 경우 예외 처리
        }

        return ReviewMapper.toReviewDtoList(reviews);
    }
}
