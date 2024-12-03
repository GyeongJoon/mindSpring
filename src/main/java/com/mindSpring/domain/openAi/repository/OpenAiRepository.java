package com.mindSpring.domain.openAi.repository;

import com.mindSpring.domain.openAi.entity.OpenAi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpenAiRepository extends JpaRepository<OpenAi, Long> {
}
