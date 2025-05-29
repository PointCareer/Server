package com.example.point_career.rs6recruit.controller;

import com.example.point_career.global.response.BaseResponse;
import com.example.point_career.rs6recruit.dto.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/recruits")
public class RecruitController {

    // BE-19 교내 추천 채용 목록 조회
    @GetMapping
    public BaseResponse<RecruitListResponse> getRecruits() {
        // TODO: 교내 추천 채용 목록 조회
        return null;
    }

    // BE-20 교내 추천 채용 상세 조회
    @GetMapping("/{recruitId}")
    public BaseResponse<RecruitDetailResponse> getRecruitDetail(@PathVariable Long recruitId) {
        // TODO: 채용 상세 조회
        return null;
    }

    // BE-21 채용 공고 검색
    @GetMapping("/search")
    public BaseResponse<RecruitListResponse> searchRecruits(@RequestParam String keyword) {
        // TODO: 채용공고 검색
        return null;
    }
}