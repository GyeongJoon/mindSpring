package com.mindSpring.domain.worry.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorryResponseDto {

    private Long id;

    private String content;

    private String openAiAnswer;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
