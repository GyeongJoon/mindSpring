package com.mindSpring.domain.aiAnswer.service;

import com.mindSpring.domain.aiAnswer.dto.AiAnswerResponseDto;
import com.mindSpring.domain.aiAnswer.entity.AiAnswer;
import com.mindSpring.domain.category.entity.Category;
import com.mindSpring.domain.aiAnswer.mapper.AiAnswerMapper;
import com.mindSpring.domain.aiAnswer.repository.AiAnswerRepository;
import com.mindSpring.domain.category.repository.CategoryRepository;
import com.mindSpring.domain.member.entity.Member;
import com.mindSpring.domain.member.repository.MemberRepository;
import com.mindSpring.domain.worry.entity.Worry;
import com.mindSpring.domain.worry.repository.WorryRepository;
import com.mindSpring.exception.ErrorCode;
import com.mindSpring.exception.appException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class AiAnswerService {

    private final MemberRepository memberRepository;
    private final CategoryRepository categoryRepository;
    private final WorryRepository worryRepository;
    private final AiAnswerRepository aiAnswerRepository;
    private final PromptService promptService;
    private final WebClient webClient;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.temperature}")
    private double temperature;

    // Ai 답변 조회
    public AiAnswerResponseDto getAiAnswer(Long memberId, Long categoryId, Long worryId, Long aiAnswerId) {
        memberRepository.findById(memberId)
                .orElseThrow(() -> new appException(ErrorCode.MEMBER_NOT_FOUND));
        categoryRepository.findById(categoryId)
                .orElseThrow(() -> new appException(ErrorCode.CATEGORY_NOT_FOUND));
        worryRepository.findById(worryId)
                .orElseThrow(() -> new appException(ErrorCode.WORRY_NOT_FOUND));
        AiAnswer aiAnswer = aiAnswerRepository.findById(aiAnswerId)
                .orElseThrow(() -> new appException(ErrorCode.AIANSWER_NOT_FOUND));

        return AiAnswerMapper.toAiAnswerDto(aiAnswer);
    }

    // AI 답변 생성
    public AiAnswerResponseDto createAiAnswer(Long memberId, Long categoryId, Long worryId) {
        try {
            Member member = memberRepository.findById(memberId)
                    .orElseThrow(() -> new appException(ErrorCode.MEMBER_NOT_FOUND));
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new appException(ErrorCode.CATEGORY_NOT_FOUND));
            Worry worry = worryRepository.findById(worryId)
                    .orElseThrow(() -> new appException(ErrorCode.WORRY_NOT_FOUND));

            String prompt = promptService.createPrompt(worry, category, member);
            log.info("프롬프트: {}", prompt);

            String aiResponse = callOpenAiApi(prompt);
            log.info("AI 응답: {}", aiResponse);

            if (aiResponse == null || aiResponse.isEmpty()) {
                throw new appException(ErrorCode.INTERNAL_SERVER_ERROR);
            }

            AiAnswer aiAnswer = new AiAnswer(worry, aiResponse);
            aiAnswerRepository.save(aiAnswer);

            return AiAnswerMapper.toAiAnswerDto(aiAnswer);
        } catch (Exception e) {
            log.error("AI 답변 생성 중 오류 발생", e);
            throw new appException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    public String callOpenAiApi(String prompt) {
        try {
            Map response = webClient.post()
                    .uri("/chat/completions")  // API 경로
                    .bodyValue(Map.of(
                            "model", model,
                            "messages", List.of(Map.of("role", "user", "content", prompt)),
                            "temperature", temperature,
                            "max_tokens", 500
                    ))
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();

            // 응답에서 content 추출 로직 수정
            if (response != null && response.containsKey("choices")) {
                List choices = (List) response.get("choices");
                if (!choices.isEmpty()) {
                    Map firstChoice = (Map) choices.get(0);
                    Map message = (Map) firstChoice.get("message");
                    return (String) message.get("content");
                }
            }

            log.error("Invalid API response: {}", response);
            throw new RuntimeException("Failed to get AI response");
        } catch (Exception e) {
            log.error("OpenAI API call failed", e);
            throw new RuntimeException("Failed to call OpenAI API", e);
        }
    }
}