package com.example.point_career.domain.recruit.controller;

import com.example.point_career.global.common.response.BaseResponse;
import com.example.point_career.domain.recruit.dto.RecruitDetailResponse;
import com.example.point_career.domain.recruit.dto.RecruitListResponse;
import com.example.point_career.domain.recruit.service.RecruitService;
import com.example.point_career.global.common.response.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@Tag(name = "RS6: 교내 추천 채용", description = "교내 추천 채용 관련 API")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RecruitController {

    private final RecruitService recruitService;

    // BE-19 교내 추천 채용 목록 조회
    @Operation(summary = "교내 추천 채용 목록 조회")
    @GetMapping("/recruits")
    public BaseResponse<RecruitListResponse> getRecruits() {
        return new BaseResponse<>(BaseResponseStatus.SUCCESS,recruitService.getRecruits());
    }

    //BE-20 교내 추천 채용 필터링 조회
    @Operation(summary = "교내 추천 채용 정렬 조회")
    @GetMapping("/recruits/sort")
    public BaseResponse<RecruitListResponse> getRecruitsSorted(@RequestParam("sortType") String sortType) {
        return new BaseResponse<>(BaseResponseStatus.SUCCESS, recruitService.getRecruitsSorted(sortType));
    }

    // BE-21 교내 추천 채용 상세 조회
    @Operation(summary = "교내 추천 채용 상세 조회")
    @GetMapping("/recruits/{recruitId}")
    public BaseResponse<RecruitDetailResponse> getRecruitDetail(@PathVariable Long recruitId) {
        return new BaseResponse<>(BaseResponseStatus.SUCCESS, recruitService.getRecruitDetail(recruitId));
    }

    // BE-22 채용 공고 검색
    @Operation(summary = "채용 공고 검색")
    @GetMapping("recruits/search")
    public BaseResponse<RecruitListResponse> searchRecruits(@RequestParam String keyword) {
        return new BaseResponse<>(BaseResponseStatus.SUCCESS, recruitService.searchRecruits(keyword));
    }

}