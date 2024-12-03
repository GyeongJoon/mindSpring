package com.mindSpring.domain.review.repository;

import com.mindSpring.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    // 상담사별 리뷰 조회
    @Query("SELECT r FROM Review r WHERE r.counselor.id = :counselorId")
    List<Review> findByCounselorId(@Param("counselorId") Long counselorId);
}
