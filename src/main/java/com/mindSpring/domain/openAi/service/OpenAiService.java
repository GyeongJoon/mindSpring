package com.mindSpring.domain.openAi.service;

import com.mindSpring.domain.category.repository.CategoryRepository;
import com.mindSpring.domain.member.repository.MemberRepository;
import com.mindSpring.domain.openAi.dto.OpenAiRequestDto;
import com.mindSpring.domain.openAi.dto.OpenAiResponseDto;
import com.mindSpring.domain.openAi.entity.OpenAi;
import com.mindSpring.domain.openAi.mapper.OpenAiMapper;
import com.mindSpring.domain.openAi.repository.OpenAiRepository;
import com.mindSpring.domain.worry.entity.Worry;
import com.mindSpring.domain.worry.repository.WorryRepository;
import com.mindSpring.exception.ErrorCode;
import com.mindSpring.exception.appException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OpenAiService {

    private final MemberRepository memberRepository;
    private final CategoryRepository categoryRepository;
    private final WorryRepository worryRepository;
    private final OpenAiRepository openAiRepository;

    // OpenAi 등록
    @Transactional
    public OpenAiResponseDto createAiAnswer(Long memberId, Long categoryId, Long worryId, OpenAiRequestDto openAiRequestDto) {
        memberRepository.findById(memberId)
                .orElseThrow(() -> new appException(ErrorCode.MEMBER_NOT_FOUND));
        categoryRepository.findById(categoryId)
                .orElseThrow(() -> new appException(ErrorCode.CATEGORY_NOT_FOUND));
        Worry worry = worryRepository.findById(worryId)
                .orElseThrow(() -> new appException(ErrorCode.WORRY_NOT_FOUND));

        OpenAi openAiEntity = OpenAiMapper.toOpenAiEntity(worry, openAiRequestDto);
        openAiRepository.save(openAiEntity);
        return OpenAiMapper.toOpenAiDto(openAiEntity);
    }

    // OpenAi 조회
    @Transactional(readOnly = true)
    public OpenAiResponseDto getAiAnswer(Long memberId, Long categoryId, Long worryId, Long openAiId) {
        memberRepository.findById(memberId)
                .orElseThrow(() -> new appException(ErrorCode.MEMBER_NOT_FOUND));
        categoryRepository.findById(categoryId)
                .orElseThrow(() -> new appException(ErrorCode.CATEGORY_NOT_FOUND));
        worryRepository.findById(worryId)
                .orElseThrow(() -> new appException(ErrorCode.WORRY_NOT_FOUND));
        OpenAi openAi = openAiRepository.findById(worryId)
                .orElseThrow(() -> new appException(ErrorCode.OPENAI_NOT_FOUND));

        return OpenAiMapper.toOpenAiDto(openAi);
    }
}
