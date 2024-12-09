package com.mindSpring.domain.counselor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CounselorResponseDto {

    private Long id;

    private String name;

    private int age;

    private String gender;

    private String career;

    private String experience;
}
