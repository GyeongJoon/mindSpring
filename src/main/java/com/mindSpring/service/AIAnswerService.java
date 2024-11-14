package com.mindSpring.service;

import com.mindSpring.domain.dto.AIAnswerRequestDto;
import com.mindSpring.domain.dto.AIAnswerResponseDto;
import com.mindSpring.domain.entity.AIAnswer;
import com.mindSpring.domain.entity.Worry;
import com.mindSpring.repository.AIAnswerRepository;
import com.mindSpring.repository.WorryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AIAnswerService {

    private final AIAnswerRepository aiAnswerRepository;
    private final WorryRepository worryRepository;
    private final RestTemplate restTemplate;

    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    @Transactional
    public AIAnswerResponseDto createAnswer(Long worryId) {
        Worry worry = worryRepository.findById(worryId)
                .orElseThrow(() -> new RuntimeException("Worry not found"));


    }

    private String getOpenAIResponse(Worry worry) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        AIAnswerRequestDto request = AIAnswerRequestDto.builder()
                .model(model)
                .messages(List.of(
                        new AIAnswerRequestDto.Message("system", "You are a helpful counselor providing advice for worries."),
                        new AIAnswerRequestDto.Message("user", worry.getContent())
                ))
                .temperature(0.7)
                .build();

        HttpEntity<AIAnswerRequestDto> entity = new HttpEntity<>(request, headers);

        OpenAIResponse response = restTemplate.postForObject(
                apiUrl,
                entity,
                OpenAIResponse.class
        );

        if (response != null && !response.getChoices().isEmpty()) {
            return response.getChoices().get(0).getMessage().getContent();
        }

        throw new RuntimeException("Failed to get response from OpenAI");
    }

    @Transactional(readOnly = true)
    public AIAnswerResponseDto getAnswer(Long worryId) {
        AIAnswer aiAnswer = aiAnswerRepository.findByWorryId(worryId)
                .orElseThrow(() -> new RuntimeException("Answer not found"));
        return aiAnswerMapper.toDto(aiAnswer);
    }
}