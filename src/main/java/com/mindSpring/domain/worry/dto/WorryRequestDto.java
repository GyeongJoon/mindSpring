package com.mindSpring.domain.worry.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorryRequestDto {

    private String content;

    private String openAiAnswer;
}
