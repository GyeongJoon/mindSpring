package com.mindSpring.domain.aiAnswer.mapper;

import com.mindSpring.domain.aiAnswer.dto.AiAnswerResponseDto;
import com.mindSpring.domain.aiAnswer.entity.AiAnswer;

public class AiAnswerMapper {

    // Entity -> Dto
    public static AiAnswerResponseDto toAiAnswerDto(AiAnswer aiAnswer) {
        return new AiAnswerResponseDto(
                aiAnswer.getId(),
                aiAnswer.getResponse()
        );
    }
}