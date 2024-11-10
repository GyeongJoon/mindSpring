package com.mindSpring.domain.mapper;

import com.mindSpring.domain.dto.MemberRequestDto;
import com.mindSpring.domain.dto.MemberResponseDto;
import com.mindSpring.domain.entity.Member;

public class MemberMapper {

    // Dto -> Entity
    public static Member toMemberEntity(MemberRequestDto memberRequestDto) {
        return Member.builder()
                .name(memberRequestDto.getName())
                .email(memberRequestDto.getEmail())
                .password(memberRequestDto.getPassword())
                .phone(memberRequestDto.getPhone())
                .age(memberRequestDto.getAge())
                .gender(memberRequestDto.getGender())
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
