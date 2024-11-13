package com.mindSpring.domain.mapper;

import com.mindSpring.domain.dto.SignupRequestDto;
import com.mindSpring.domain.dto.MemberResponseDto;
import com.mindSpring.domain.entity.Member;

public class MemberMapper {

    // Dto -> Entity
    public static Member toMemberEntity(SignupRequestDto signupRequestDto) {
        return Member.builder()
                .name(signupRequestDto.getName())
                .email(signupRequestDto.getEmail())
                .password(signupRequestDto.getPassword())
                .phone(signupRequestDto.getPhone())
                .age(signupRequestDto.getAge())
                .gender(signupRequestDto.getGender())
                .build();
    }

    // Entity -> Dto
    public static MemberResponseDto toMemberDto(Member member) {
        return MemberResponseDto.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .phone(member.getPhone())
                .age(member.getAge())
                .gender(member.getGender())
                .build();
    }
}
