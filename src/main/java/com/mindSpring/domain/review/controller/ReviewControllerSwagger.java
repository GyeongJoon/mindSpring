package com.mindSpring.domain.review.controller;

import com.mindSpring.common.ResponseMessage;
import com.mindSpring.domain.review.dto.ReviewRequestDto;
import com.mindSpring.exception.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "리뷰 관리", description = "리뷰 CRUD API")
public interface ReviewControllerSwagger {

    @Operation(summary = "리뷰 등록(리뷰 작성 페이지)", description = "새로운 리뷰를 등록합니다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "등록 성공",
                            content = @Content(schema = @Schema(implementation = ResponseMessage.class))),
                    @ApiResponse(responseCode = "400", description = "회원을 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "401", description = "상담사를 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    ResponseEntity<ResponseMessage<Object>> createReview(
            @Parameter(description = "회원 ID", required = true) Long memberId,
            @Parameter(description = "상담사 ID", required = true) Long counselorId,
            @Parameter(description = "리뷰 정보", required = true) ReviewRequestDto reviewRequestDto
    );

    @Operation(summary = "상담사별 리뷰 조회(리뷰 목록 페이지)", description = "상담사별 리뷰 정보를 조회합니다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "조회 성공",
                            content = @Content(schema = @Schema(implementation = ResponseMessage.class))),
                    @ApiResponse(responseCode = "400", description = "회원을 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "401", description = "상담사를 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    ResponseEntity<ResponseMessage<Object>> getReviews(
            @Parameter(description = "회원 ID", required = true) Long memberId,
            @Parameter(description = "상담사 ID", required = true) Long counselorId
    );

    @Operation(summary = "리뷰 조회(리뷰 상세 페이지)", description = "리뷰ID로 리뷰 정보를 조회합니다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "조회 성공",
                            content = @Content(schema = @Schema(implementation = ResponseMessage.class))),
                    @ApiResponse(responseCode = "400", description = "회원을 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "402", description = "리뷰를 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    ResponseEntity<ResponseMessage<Object>> getReview(
            @Parameter(description = "회원 ID", required = true) Long memberId,
            @Parameter(description = "리뷰 ID", required = true) Long reviewId
    );
}
