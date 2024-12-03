package com.mindSpring.domain.openAi.mapper;

import com.mindSpring.domain.openAi.dto.OpenAiRequestDto;
import com.mindSpring.domain.openAi.dto.OpenAiResponseDto;
import com.mindSpring.domain.openAi.entity.OpenAi;
import com.mindSpring.domain.worry.entity.Worry;

public class OpenAiMapper {
    // Entity -> Dto (조회)
    public static OpenAiResponseDto toOpenAiDto(OpenAi openAi) {
        return OpenAiResponseDto.builder()
                .id(openAi.getId())
                .aiAnswer(openAi.getAiAnswer())
                .build();
    }

    // Dto -> Entity (등록)
    public static OpenAi toOpenAiEntity(Worry worry, OpenAiRequestDto openAiRequestDto) {
        return OpenAi.builder()
                .aiAnswer(openAiRequestDto.getAiAnswer())
                .worry(worry)
                .build();
    }
}
