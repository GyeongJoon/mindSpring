package com.mindSpring.domain.category.controller;

import com.mindSpring.domain.category.dto.CategoryResponseDto;
import com.mindSpring.domain.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member/{memberId}/category")
public class CategoryController implements CategoryControllerSwagger{

    private final CategoryService categoryService;

    // 카테고리 조회
    @GetMapping("/{categoryId}")
    @Override
    public ResponseEntity<CategoryResponseDto> getCategory(@PathVariable Long memberId, @PathVariable Long categoryId) {
        CategoryResponseDto category = categoryService.getCategory(memberId, categoryId);
        return ResponseEntity.ok(category);
    }

    // 카테고리 전체 조회
    @GetMapping
    @Override
    public ResponseEntity<List<CategoryResponseDto>> getCategoryList(@PathVariable Long memberId) {
        List<CategoryResponseDto> categories = categoryService.getCategories(memberId);
        return ResponseEntity.ok(categories);
    }
}
