package com.mindSpring.domain.category.mapper;

import com.mindSpring.domain.category.dto.CategoryResponseDto;
import com.mindSpring.domain.category.entity.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {

    // Entity -> Dto
    public static CategoryResponseDto toCategoryDto(Category category) {
        return CategoryResponseDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    // Entity -> Dto 전체
    public static List<CategoryResponseDto> toCategoryDtoList(List<Category> categoryList) {
        return categoryList.stream()
                .map(CategoryMapper::toCategoryDto)
                .collect(Collectors.toList());
    }
}
