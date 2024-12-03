package com.mindSpring.domain.member.controller;

import com.mindSpring.common.ResponseMessage;
import com.mindSpring.domain.member.dto.LoginRequestDto;
import com.mindSpring.domain.member.dto.MemberResponseDto;
import com.mindSpring.domain.member.dto.SignupRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import com.mindSpring.common.ResponseMessage;

@Tag(name = "회원 관리", description = "회원 CRUD API")
public interface MemberControllerSwagger {

    // 회원가입
    @Operation(summary = "회원가입(회원가입 페이지)", description = "새로운 회원을 등록합니다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "회원가입 성공",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMessage.class))),
                    @ApiResponse(responseCode = "400", description = "회원이 이미 존재함",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    ResponseEntity<ResponseMessage<Object>> createMember(
            @Parameter(description = "회원가입 정보", required = true) SignupRequestDto signupRequestDto
    );

    // 로그인
    @Operation(summary = "로그인(로그인 페이지)", description = "회원 로그인을 합니다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "로그인 성공",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMessage.class))),
                    @ApiResponse(responseCode = "400", description = "회원이 존재 하지 않음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    ResponseEntity<ResponseMessage<Object>> loginMember(
            @Parameter(description = "로그인 정보", required = true) LoginRequestDto loginRequestDto
    );

    // 프로필
    @Operation(summary = "프로필(프로필 페이지)", description = "사용자 프로필을 조회합니다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "프로필 조회 성공",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMessage.class))),
                    @ApiResponse(responseCode = "400", description = "회원이 존재 하지 않음",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    ResponseEntity<ResponseMessage<Object>> getMemberId(
            @Parameter(description = "회원 ID", required = true)  Long memberId
    );
}
