package com.mindSpring.domain.counselor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CounselorRequestDto {

    private String name;

    private int age;

    private String gender;

    private String career;
}