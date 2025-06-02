package com.example.point_career.domain.pointrecommend.controller;

import com.example.point_career.domain.pointrecommend.dto.PointRecommendInputRequest;
import com.example.point_career.domain.pointrecommend.dto.PointRecommendInputResponse;
import com.example.point_career.domain.pointrecommend.dto.PointRecommendListResponse;
import com.example.point_career.domain.pointrecommend.dto.PointRecommendResultResponse;
import com.example.point_career.global.common.response.BaseResponse;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@Tag(name = "RS4: 맞춤형 포인트 추천", description = "포인트 추천 입력/결과/목록 제공 API")
@RestController
@RequestMapping("/api/v1/points/recommend")
public class PointRecommendController {

    // BE-10 맞춤형 포인트 추천 입력 제공
    @Operation(summary = "맞춤형 포인트 추천 입력 제공")
    @PostMapping("/input")
    public BaseResponse<PointRecommendInputResponse> recommendInput(@RequestBody PointRecommendInputRequest request) {
        // TODO: 입력값 저장
        return null;
    }

    // BE-11 맞춤형 포인트 추천 결과 제공
    @Operation(summary = "맞춤형 포인트 추천 결과 제공")
    @GetMapping("/result")
    public BaseResponse<PointRecommendResultResponse> recommendResult() {
        // TODO: 최근 입력 기반 상위 2개 추천 결과 반환
        return null;
    }

    // BE-12 맞춤형 포인트 활동 추천 목록 조회
    @Operation(summary = "맞춤형 포인트 활동 추천 목록 조회")
    @GetMapping("/list")
    public BaseResponse<PointRecommendListResponse> recommendList() {
        // TODO: 전체 추천 활동 목록 반환
        return null;
    }
}
