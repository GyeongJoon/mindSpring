package com.mindSpring.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignupRequestDto {

    private String email;

    private String name;

    private String password;

    private int age;

    private String gender;

    private String job;
}
