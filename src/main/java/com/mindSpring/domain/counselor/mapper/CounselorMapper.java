package com.mindSpring.domain.counselor.mapper;

import com.mindSpring.domain.counselor.dto.CounselorResponseDto;
import com.mindSpring.domain.counselor.entity.Counselor;

import java.util.List;
import java.util.stream.Collectors;

public class CounselorMapper {

    // Entity -> Dto
    public static CounselorResponseDto toCounselorDto(Counselor counselor) {
        return CounselorResponseDto.builder()
                .id(counselor.getId())
                .name(counselor.getName())
                .age(counselor.getAge())
                .gender(counselor.getGender())
                .career(counselor.getCareer())
                .experience(counselor.getExperience())
                .build();
    }

    public static List<CounselorResponseDto> toCounselorDtoList(List<Counselor> counselors) {
        return counselors.stream()
                .map(CounselorMapper::toCounselorDto)
                .collect(Collectors.toList());
    }
}
