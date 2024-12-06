package com.mindSpring.domain.member.mapper;

import com.mindSpring.domain.member.dto.SignupRequestDto;
import com.mindSpring.domain.member.dto.MemberResponseDto;
import com.mindSpring.domain.member.entity.Member;

public class MemberMapper {

    // Dto -> Entity(회원가입)
    public static Member toMemberEntity(SignupRequestDto signupRequestDto) {
        return Member.builder()
                .email(signupRequestDto.getEmail())
                .name(signupRequestDto.getName())
                .password(signupRequestDto.getPassword())
                .age(signupRequestDto.getAge())
                .gender(signupRequestDto.getGender())
                .job(signupRequestDto.getJob())
                .build();
    }

    // Entity -> Dto
    public static MemberResponseDto toMemberDto(Member member) {
        return MemberResponseDto.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .job(member.getJob())
                .age(member.getAge())
                .gender(member.getGender())
                .build();
    }
}
