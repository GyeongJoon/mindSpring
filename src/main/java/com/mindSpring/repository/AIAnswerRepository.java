package com.mindSpring.repository;

import com.mindSpring.domain.entity.AIAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AIAnswerRepository extends JpaRepository<AIAnswer, Long> {
}
