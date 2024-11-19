package com.mindSpring.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResponseDto {

    private Long id;

    private String email;

    private String name;

    private String job;

    private int age;

    private String gender;
}
