package com.mindSpring.domain.mapper;

import com.mindSpring.domain.dto.WorryRequestDto;
import com.mindSpring.domain.entity.Worry;
import com.mindSpring.domain.entity.Category;
import com.mindSpring.domain.entity.Member;

public class WorryMapper {

    // Dto -> Entity
    public static Worry toWorryEntity(Member member, Category category, WorryRequestDto worryRequestDto) {
        return Worry.builder()
                .content(worryRequestDto.getContent())
                .category(category)
                .member(member)
                .build();
    }

    // Entity -> Dto
}
