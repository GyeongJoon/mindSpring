package com.mindSpring.domain.review.mapper;

import com.mindSpring.domain.counselor.entity.Counselor;
import com.mindSpring.domain.member.entity.Member;
import com.mindSpring.domain.review.dto.ReviewRequestDto;
import com.mindSpring.domain.review.dto.ReviewResponseDto;
import com.mindSpring.domain.review.entity.Review;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewMapper {

    // Dto -> Entity
    public static Review toReviewEntity (Member member, Counselor counselor, ReviewRequestDto reviewRequestDto) {
        return Review.builder()
                .rating(reviewRequestDto.getRating())
                .content(reviewRequestDto.getContent())
                .member(member)
                .counselor(counselor)
                .build();
    }

    // Entity -> Dto
    public static ReviewResponseDto toReviewDto (Review review) {
        return ReviewResponseDto.builder()
                .id(review.getId())
                .rating((int) review.getRating())
                .content(review.getContent())
                .build();
    }

    // Entity -> Dto
    public static List<ReviewResponseDto> toReviewDtoList (List<Review> reviews) {
        return reviews.stream()
                .map(ReviewMapper::toReviewDto)
                .collect(Collectors.toList());
    }
}
