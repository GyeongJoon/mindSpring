package com.mindSpring.domain.counselor.repository;

import com.mindSpring.domain.counselor.entity.Counselor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounselorRepository extends JpaRepository<Counselor, Long> {
}
