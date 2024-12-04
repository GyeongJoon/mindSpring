package com.mindSpring.domain.worry.repository;

import com.mindSpring.domain.worry.entity.Worry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorryRepository extends JpaRepository<Worry, Long> {

    // 최신순
    @Query("SELECT w FROM Worry w WHERE w.member.id = :memberId ORDER BY w.createdAt DESC")
    List<Worry> findAllByMemberId(@Param("memberId") Long memberId);
}
