package com.mindSpring.domain.aiAnswer.service;

import com.mindSpring.domain.category.entity.Category;
import com.mindSpring.domain.member.entity.Member;
import com.mindSpring.domain.worry.entity.Worry;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PromptService {
    // 프롬프트 생성 메서드
    String createPrompt(Worry worry, Category category, Member member) {

        String expertRole = getExpertRole(category.getName());

        // null 처리를 위한 기본값 설정
        String worryContent = Optional.ofNullable(worry.getContent())
                .filter(content -> !content.trim().isEmpty())
                .orElse("특별한 고민 내용 없음");

        String memberAge = Optional.ofNullable(member.getAge())
                .map(String::valueOf)
                .orElse("정보 없음");

        String memberGender = Optional.ofNullable(member.getGender())
                .filter(gender -> !gender.trim().isEmpty())
                .orElse("정보 없음");

        String memberJob = Optional.ofNullable(member.getJob())
                .filter(job -> !job.trim().isEmpty())
                .orElse("정보 없음");

        return String.format("""
            당신은 %s입니다. 다음 고민에 대해 전문가적 관점에서 공감하고 실질적인 조언을 해주세요:
            
            [전문 분야: %s]
            고민자 정보:
            이름: %s
            나이: %s
            성별: %s
            직업: %s
            고민 내용: %s
            
            답변 형식:
            1. 고민에 대한 전문가적 공감
            2. 전문적인 관점에서의 상황 분석
            3. 해당 분야의 경험을 바탕으로 한 구체적인 해결 방안 제시
            4. 전문가로서의 응원의 말
            
            답변은 전문성을 바탕으로 하되, 친근하고 따뜻한 톤으로 작성해주세요.
            전문 용어를 사용할 경우 쉽게 풀어서 설명해주세요.
            1, 2, 3, 4로 나누지 말고 한 문단 형식으로 작성해주세요.
            500토큰 내로 글을 작성해주세요.
            """, expertRole, category.getName(),member.getName(),
                memberAge, memberGender, memberJob, worryContent);
    }

    // 전문가 역할 결정 메서드
    private String getExpertRole(String categoryName) {
        return switch (categoryName) {
            case "LOVE" -> "연애 심리 전문 상담사";
            case "COURSE" -> "커리어 및 진로 상담 전문가";
            case "취업" -> "취업 컨설턴트";
            case "직장" -> "직장 생활 전문 카운슬러";
            case "FRIENDSHIP" -> "대인 관계 전문 심리 상담사";
            case "FAMILY" -> "가족 관계 전문 상담 심리학자";
            case "학업" -> "학습 및 교육 전문 컨설턴트";
            case "건강" -> "정신 건강 의학 전문의";
            case "OTHER" -> "종합 심리 상담 전문가";
            default -> "전문 상담가";
        };
    }
}
