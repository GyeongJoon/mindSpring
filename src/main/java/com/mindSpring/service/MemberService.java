package com.mindSpring.service;

import com.mindSpring.domain.dto.LoginRequestDto;
import com.mindSpring.domain.dto.SignupRequestDto;
import com.mindSpring.domain.dto.MemberResponseDto;
import com.mindSpring.domain.entity.Member;
import com.mindSpring.domain.mapper.MemberMapper;
import com.mindSpring.exception.ErrorCode;
import com.mindSpring.exception.appException;
import com.mindSpring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원 조회 API
    @Transactional(readOnly = true)
    public MemberResponseDto getMemberId(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new appException(ErrorCode.MEMBER_NOT_FOUND));

        return MemberMapper.toMemberDto(member);
    }

    // 회원 등록 API
    @Transactional
    public MemberResponseDto createMember(SignupRequestDto signupRequestDto) {
        memberRepository.findByEmail(signupRequestDto.getEmail())
                .ifPresent(member -> {
                    throw new appException(ErrorCode.MEMBER_ALREADY_EXISTS);
                });

        Member memberEntity = MemberMapper.toMemberEntity(signupRequestDto);
        memberRepository.save(memberEntity);
        return MemberMapper.toMemberDto(memberEntity);
    }

    // 회원 로그인 API
    @Transactional(readOnly = true)
    public MemberResponseDto login(LoginRequestDto loginRequestDto) {
        Member member = memberRepository.findByEmail(loginRequestDto.getEmail())
                .orElseThrow(() -> new appException(ErrorCode.MEMBER_NOT_FOUND));

        // 비밀번호 검증
        if (!member.getPassword().equals(loginRequestDto.getPassword())) {
            throw new appException(ErrorCode.INVALID_PASSWORD);
        }

        // 로그인 성공 메시지 반환
        return MemberMapper.toMemberDto(member);
    }

    // 회원 수정 API
    @Transactional
    public MemberResponseDto updateMember(Long memberId, SignupRequestDto signupRequestDto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new appException(ErrorCode.MEMBER_NOT_FOUND));

        member.updateMemberInfo(signupRequestDto);
        return MemberMapper.toMemberDto(member);
    }

    // 회원 삭제 API
    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new appException(ErrorCode.MEMBER_NOT_FOUND));

        memberRepository.delete(member);
    }
}
