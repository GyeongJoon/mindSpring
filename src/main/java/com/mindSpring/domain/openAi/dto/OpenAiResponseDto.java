package com.mindSpring.domain.openAi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpenAiResponseDto {

    private Long id;

    private String aiAnswer;
}
