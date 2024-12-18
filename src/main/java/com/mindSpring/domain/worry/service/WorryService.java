package com.mindSpring.domain.worry.service;

import com.mindSpring.domain.category.entity.Category;
import com.mindSpring.domain.category.repository.CategoryRepository;
import com.mindSpring.domain.member.entity.Member;
import com.mindSpring.domain.member.repository.MemberRepository;
import com.mindSpring.domain.worry.dto.WorryRequestDto;
import com.mindSpring.domain.worry.dto.WorryResponseDto;
import com.mindSpring.domain.worry.entity.Worry;
import com.mindSpring.domain.worry.mapper.WorryMapper;
import com.mindSpring.domain.worry.repository.WorryRepository;
import com.mindSpring.exception.ErrorCode;
import com.mindSpring.exception.appException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorryService {

    private final MemberRepository memberRepository;
    private final CategoryRepository categoryRepository;
    private final WorryRepository worryRepository;

    // 고민 등록 API
    @Transactional
    public WorryResponseDto createWorry(Long memberId, Long categoryId, WorryRequestDto worryRequestDto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new appException(ErrorCode.MEMBER_NOT_FOUND));
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new appException(ErrorCode.CATEGORY_NOT_FOUND));

        Worry worryEntity = WorryMapper.toWorryEntity(member, category, worryRequestDto);
        worryRepository.save(worryEntity);
        return WorryMapper.toWorryDto(worryEntity);
    }

    // 고민 조회 API
    @Transactional(readOnly = true)
    public WorryResponseDto getWorry(Long memberId, Long categoryId, Long worryId) {
        memberRepository.findById(memberId)
                .orElseThrow(() -> new appException(ErrorCode.MEMBER_NOT_FOUND));
        categoryRepository.findById(categoryId)
                .orElseThrow(() -> new appException(ErrorCode.CATEGORY_NOT_FOUND));
        Worry worry = worryRepository.findById(worryId)
                .orElseThrow(() -> new appException(ErrorCode.WORRY_NOT_FOUND));

        if(categoryId != worry.getCategory().getId()){
            throw new appException(ErrorCode.WORRY_NOT_FOUND);
        }

        return WorryMapper.toWorryDto(worry);
    }

    // 고민 전체 조회 API
    @Transactional(readOnly = true)
    public List<WorryResponseDto> getWorryPage(Long memberId) {
        memberRepository.findById(memberId)
                .orElseThrow(() -> new appException(ErrorCode.MEMBER_NOT_FOUND));

        List<Worry> allByMemberId = worryRepository.findAllByMemberId(memberId);

        return WorryMapper.toWorryDtoList(allByMemberId);
    }
}
