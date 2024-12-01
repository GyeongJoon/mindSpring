package com.mindSpring.domain.aiAnswer.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AiAnswerRequestDto {
    private Long memberId;
    private Long categoryId;
    private Long worryId;
}