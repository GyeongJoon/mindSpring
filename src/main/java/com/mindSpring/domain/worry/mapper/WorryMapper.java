package com.mindSpring.domain.worry.mapper;

import com.mindSpring.domain.worry.dto.WorryRequestDto;
import com.mindSpring.domain.worry.dto.WorryResponseDto;
import com.mindSpring.domain.worry.entity.Worry;
import com.mindSpring.domain.category.entity.Category;
import com.mindSpring.domain.member.entity.Member;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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

    // Entity -> Dto
    public static List<WorryResponseDto> toWorryDtoList(List<Worry> worrys) {
        return worrys.stream().map(WorryMapper::toWorryDto).collect(Collectors.toList());
    }
}
