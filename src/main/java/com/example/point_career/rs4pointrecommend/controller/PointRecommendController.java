package com.example.point_career.rs4pointrecommend.controller;

import com.example.point_career.global.response.BaseResponse;
import com.example.point_career.rs4pointrecommend.dto.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/points/recommend")
public class PointRecommendController {

    // BE-10 맞춤형 포인트 추천 입력 제공
    @PostMapping("/input")
    public BaseResponse<PointRecommendInputResponse> recommendInput(@RequestBody PointRecommendInputRequest request) {
        // TODO: 입력값 저장
        return null;
    }

    // BE-11 맞춤형 포인트 추천 결과 제공
    @GetMapping("/result")
    public BaseResponse<PointRecommendResultResponse> recommendResult() {
        // TODO: 최근 입력 기반 상위 2개 추천 결과 반환
        return null;
    }

    // BE-12 맞춤형 포인트 활동 추천 목록 조회
    @GetMapping("/list")
    public BaseResponse<PointRecommendListResponse> recommendList() {
        // TODO: 전체 추천 활동 목록 반환
        return null;
    }
}