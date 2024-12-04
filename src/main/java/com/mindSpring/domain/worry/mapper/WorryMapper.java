package com.mindSpring.domain.worry.mapper;

import com.mindSpring.domain.worry.dto.WorryRequestDto;
import com.mindSpring.domain.worry.dto.WorryResponseDto;
import com.mindSpring.domain.worry.entity.Worry;
import com.mindSpring.domain.category.entity.Category;
import com.mindSpring.domain.member.entity.Member;
import org.springframework.data.domain.Page;

public class WorryMapper {

    // Dto -> Entity
    public static Worry toWorryEntity(Member member, Category category, WorryRequestDto worryRequestDto) {
        return Worry.builder()
                .content(worryRequestDto.getContent())
                .openAiAnswer(worryRequestDto.getOpenAiAnswer())
                .category(category)
                .member(member)
                .build();
    }

    // Entity -> Dto
    public static WorryResponseDto toWorryDto(Worry worry) {
        return WorryResponseDto.builder()
                .id(worry.getId())
                .content(worry.getContent())
                .openAiAnswer(worry.getOpenAiAnswer())
                .build();
    }

    // Entity -> Dto (페이지)
    public static Page<WorryResponseDto> toWorryDtoPage(Page<Worry> worrys) {
        return worrys.map(WorryMapper::toWorryDto);
    }
}
