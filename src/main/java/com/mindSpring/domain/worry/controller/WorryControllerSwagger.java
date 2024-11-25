package com.mindSpring.domain.worry.controller;

import com.mindSpring.domain.worry.dto.WorryRequestDto;
import com.mindSpring.domain.worry.dto.WorryResponseDto;
import com.mindSpring.exception.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

@Tag(name = "고민 관리",  description = "고민 CRUD API")
public interface WorryControllerSwagger {

    @Operation(summary = "고민 등록(고민 작성 페이지)", description = "새로운 고민을 등록합니다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "등록 성공"),
                    @ApiResponse(responseCode = "400", description = "회원을 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "401", description = "카테고리를 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    ResponseEntity<String> createWorry(
            @Parameter(description = "회원 ID", required = true) Long memberId,
            @Parameter(description = "카테고리 ID", required = true) Long categoryId,
            @Parameter(description = "고민 정보", required = true) WorryRequestDto worryRequestDto
    );

    @Operation(summary = "고민 조회(고민 상세 페이지)", description = "고민 ID로 고민 정보를 조회합니다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "조회 성공",
                            content = @Content(schema = @Schema(implementation = WorryResponseDto.class))),
                    @ApiResponse(responseCode = "400", description = "회원을 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "401", description = "카테고리를 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "402", description = "고민를 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    ResponseEntity<WorryResponseDto> getWorry(
            @Parameter(description = "회원 ID", required = true) Long memberId,
            @Parameter(description = "카테고리 ID", required = true) Long categoryId,
            @Parameter(description = "고민 ID", required = true) Long worryId
    );

    @Operation(summary = "고민 전체 조회(고민 목록 페이지)", description = "고민 전체 정보를 조회합니다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "조회 성공",
                            content = @Content(schema = @Schema(implementation = WorryResponseDto.class))),
                    @ApiResponse(responseCode = "400", description = "회원을 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "401", description = "카테고리를 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    ResponseEntity<Page<WorryResponseDto>> getWorries(
            @Parameter(description = "회원 ID", required = true) Long memberId,
            @Parameter(description = "카테고리 ID", required = true) Long categoryId,
            @Parameter(description = "page", required = true) int page,
            @Parameter(description = "size", required = true) int size
    );
}
