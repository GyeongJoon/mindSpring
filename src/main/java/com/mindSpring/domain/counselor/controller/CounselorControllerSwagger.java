package com.mindSpring.domain.counselor.controller;

import com.mindSpring.domain.counselor.dto.CounselorResponseDto;
import com.mindSpring.exception.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "상담사 관리", description = "상담사 CRUD API")
public interface CounselorControllerSwagger {

    @Operation(summary = "상담사 전체 조회(상담사 목록 페이지)", description = "상담사 전체 리스트를 조회합니다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "조회 성공"),
                    @ApiResponse(responseCode = "400", description = "회원을 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    ResponseEntity<List<CounselorResponseDto>> getCounselors(
            @Parameter(description = "회원 ID", required = true) Long memberId
    );
    @Operation(summary = "상담사 조회(상담사 상세 페이지)", description = "상담사 ID로 상담사 정보를 조회합니다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "조회 성공"),
                    @ApiResponse(responseCode = "400", description = "회원을 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "401", description = "상담사를 찾을 수 없음",
                                content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    ResponseEntity<CounselorResponseDto> getCounselor(
            @Parameter(description = "회원 ID", required = true) Long memberId,
            @Parameter(description = "상담사 ID", required = true) Long counselorId
    );
}
