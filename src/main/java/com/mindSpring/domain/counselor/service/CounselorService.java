package com.mindSpring.domain.counselor.service;

import com.mindSpring.domain.counselor.dto.CounselorResponseDto;
import com.mindSpring.domain.counselor.entity.Counselor;
import com.mindSpring.domain.counselor.mapper.CounselorMapper;
import com.mindSpring.domain.counselor.repository.CounselorRepository;
import com.mindSpring.domain.member.repository.MemberRepository;
import com.mindSpring.exception.ErrorCode;
import com.mindSpring.exception.appException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CounselorService {

    private final MemberRepository memberRepository;
    private final CounselorRepository counselorRepository;

    // 상담사 조회 API
    @Transactional(readOnly = true)
    public CounselorResponseDto getCounselor(Long memberId, Long counselorId) {
        memberRepository.findById(memberId)
                .orElseThrow(() -> new appException(ErrorCode.MEMBER_NOT_FOUND));
        Counselor counselor = counselorRepository.findById(counselorId)
                .orElseThrow(() -> new appException(ErrorCode.COUNSELOR_NOT_FOUND));

        return CounselorMapper.toCounselorDto(counselor);
    }

    // 상담사 전체 조회 API
    @Transactional(readOnly = true)
    public List<CounselorResponseDto> getCounselors(Long memberId) {
        memberRepository.findById(memberId)
                .orElseThrow(() -> new appException(ErrorCode.MEMBER_NOT_FOUND));

        List<Counselor> counselors = counselorRepository.findAll();

        return CounselorMapper.toCounselorDtoList(counselors);
    }
}
