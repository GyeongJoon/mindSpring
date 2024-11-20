package com.mindSpring.domain.category.service;

import com.mindSpring.domain.category.dto.CategoryResponseDto;
import com.mindSpring.domain.category.entity.Category;
import com.mindSpring.domain.category.mapper.CategoryMapper;
import com.mindSpring.domain.category.repository.CategoryRepository;
import com.mindSpring.domain.member.repository.MemberRepository;
import com.mindSpring.exception.ErrorCode;
import com.mindSpring.exception.appException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final MemberRepository memberRepository;
    private final CategoryRepository categoryRepository;

    // 카테고리 조회 API
    @Transactional(readOnly = true)
    public CategoryResponseDto getCategory(Long memberId, Long categoryId) {
        memberRepository.findById(memberId)
                .orElseThrow(() -> new appException(ErrorCode.MEMBER_NOT_FOUND));

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new appException(ErrorCode.CATEGORY_NOT_FOUND));

        return CategoryMapper.toCategoryDto(category);
    }

    // 카테고리 전체 조회 API
    @Transactional(readOnly = true)
    public List<CategoryResponseDto> getCategories(Long memberId) {
        memberRepository.findById(memberId)
                .orElseThrow(() -> new appException(ErrorCode.MEMBER_NOT_FOUND));

        List<Category> categories = categoryRepository.findAll();

        return CategoryMapper.toCategoryDtoList(categories);
    }
}
