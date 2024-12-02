package com.mindSpring.domain.aiAnswer.repository;

import com.mindSpring.domain.aiAnswer.entity.AiAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AiAnswerRepository extends JpaRepository<AiAnswer, Long> {
}
