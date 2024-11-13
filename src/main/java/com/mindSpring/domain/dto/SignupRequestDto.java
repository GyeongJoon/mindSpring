package com.mindSpring.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignupRequestDto {

    private String name;

    private String email;

    private String password;

    private String phone;

    private int age;

    private String gender;
}
