package com.mindSpring.service;

import com.mindSpring.domain.dto.CategoryRequestDto;
import com.mindSpring.domain.dto.WorryRequestDto;
import com.mindSpring.domain.dto.WorryResponseDto;
import com.mindSpring.domain.entity.Member;
import com.mindSpring.domain.mapper.WorryMapper;
import com.mindSpring.exception.ErrorCode;
import com.mindSpring.exception.appException;
import com.mindSpring.repository.MemberRepository;
import com.mindSpring.repository.WorryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WorryService {

    private final MemberRepository memberRepository;
    private final WorryRepository worryRepository;

    // 고민 조회 API

    // 고민 전체 조회 API

    // 고민 등록 API
    @Transactional
    public WorryResponseDto createWorry(Long memberId, Long worryId, WorryRequestDto worryRequestDto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new appException(ErrorCode.MEMBER_NOT_FOUND));

        WorryMapper.toWorryEntity(member, c)


        worryRepository.save(worryRequestDto);
    }
}
