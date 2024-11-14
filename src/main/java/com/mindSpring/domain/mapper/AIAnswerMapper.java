package com.mindSpring.domain.mapper;

import com.mindSpring.domain.dto.AIAnswerRequestDto;
import com.mindSpring.domain.dto.AIAnswerResponseDto;
import com.mindSpring.domain.entity.AIAnswer;
import com.mindSpring.domain.entity.Worry;

public class AIAnswerMapper {

    public static AIAnswer toEntity(AIAnswerRequestDto dto, Worry worry) {
        return AIAnswer.builder()
                .content(dto.getContent())
                .worry(worry)
                .build();
    }

    public static AIAnswerResponseDto toDto(AIAnswer entity) {
        return AIAnswerResponseDto.builder()
                .id(entity.getId())
                .content(entity.getContent())
                .worryTitle(entity.getWorry().getTitle())
                .build();
    }
}