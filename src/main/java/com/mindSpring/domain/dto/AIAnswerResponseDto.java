package com.mindSpring.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AIAnswerResponseDto {

    private Long id;

    private String content;

    private String worryTitle;
}
