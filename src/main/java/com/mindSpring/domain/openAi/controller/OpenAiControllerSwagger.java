package com.mindSpring.domain.openAi.controller;

import com.mindSpring.domain.openAi.dto.OpenAiRequestDto;
import com.mindSpring.domain.openAi.dto.OpenAiResponseDto;
import com.mindSpring.exception.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "OpenAI 관리(허수진 GPT)", description = "OpenAI CRUD API")
public interface OpenAiControllerSwagger {

    // OpenAI 조회
    @Operation(summary = "OpenAI 조회(고민 결과 페이지)", description = "AI응답 ID로 정보를 조회합니다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "조회 성공",
                            content = @Content(schema = @Schema(implementation = OpenAiResponseDto.class))),
                    @ApiResponse(responseCode = "400", description = "회원을 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "401", description = "카테고리를 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "402", description = "고민를 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "403", description = "AI응답을 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    ResponseEntity<OpenAiResponseDto> getOpenAi(
            @Parameter(description = "회원 ID", required = true) Long memberId,
            @Parameter(description = "카테고리 ID", required = true) Long categoryId,
            @Parameter(description = "고민 ID", required = true) Long worryId,
            @Parameter(description = "OpenAI ID", required = true) Long openAiId
    );

    // OpenAI 생성
    @Operation(summary = "OpenAI 생성(고민 작성 페이지)", description = "고민 ID에 맞는 AI응답을 생성합니다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "생성 성공",
                            content = @Content(schema = @Schema(implementation = OpenAiResponseDto.class))),
                    @ApiResponse(responseCode = "400", description = "회원을 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "401", description = "카테고리를 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "402", description = "고민를 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    ResponseEntity<String> createOpenAi(
            @Parameter(description = "회원 ID", required = true) Long memberId,
            @Parameter(description = "카테고리 ID", required = true) Long categoryId,
            @Parameter(description = "고민 ID", required = true) Long worryId,
            @Parameter(description = "GPT 응답", required = true) OpenAiRequestDto openAiRequestDto
    );
}
