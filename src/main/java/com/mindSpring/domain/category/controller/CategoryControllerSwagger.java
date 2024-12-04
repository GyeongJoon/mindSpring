package com.mindSpring.domain.category.controller;

import com.mindSpring.common.ResponseMessage;
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

@Tag(name = "카테고리 관리", description = "카테고리 CRUD API")
public interface CategoryControllerSwagger {

    // 카테고리 조회
    @Operation(summary = "카테고리 조회(고민 작성 페이지)", description = "카테고리 ID로 정보를 조회합니다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "조회 성공",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMessage.class))),
                    @ApiResponse(responseCode = "400", description = "회원을 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "401", description = "카테고리를 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    ResponseEntity<ResponseMessage<Object>> getCategory(
            @Parameter(description = "회원 ID", required = true) Long memberId,
            @Parameter(description = "카테고리 ID", required = true) Long categoryId
    );

    // 카테고리 전체 조회
    @Operation(summary = "카테고리 전체 조회(고민 작성 페이지)", description = "카테고리 전체 정보를 조회합니다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "조회 성공",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMessage.class))),
                    @ApiResponse(responseCode = "400", description = "회원을 찾을 수 없음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    ResponseEntity<ResponseMessage<Object>> getCategoryList(
            @Parameter(description = "회원 ID", required = true) Long memberId
    );
}
