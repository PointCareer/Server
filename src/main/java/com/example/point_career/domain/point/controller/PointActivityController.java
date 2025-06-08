package com.example.point_career.domain.point.controller;

import com.example.point_career.global.common.response.BaseResponse;
import com.example.point_career.global.common.response.BaseResponseStatus;
import com.example.point_career.domain.point.dto.PointActivityDetailResponse;
import com.example.point_career.domain.point.dto.PointActivityListResponse;
import com.example.point_career.domain.point.service.PointActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@Tag(name = "RS5: 포인트 활동", description = "포인트 활동 전체/검색/정렬/상세 조회 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/points/activities")
public class PointActivityController {

    private final PointActivityService pointActivityService;

    // BE-14 포인트 활동 목록 조회
    @Operation(summary = "포인트 활동 목록 조회")
    @GetMapping
    public BaseResponse<PointActivityListResponse> getPointActivities() {
        return new BaseResponse<>(BaseResponseStatus.SUCCESS, pointActivityService.getPointActivities());
    }

    // BE-15 포인트 활동 검색
    @Operation(summary = "포인트 활동 검색")
    @GetMapping("/search")
    public BaseResponse<PointActivityListResponse> searchPointActivities(@RequestParam String keyword) {
        return new BaseResponse<>(BaseResponseStatus.SUCCESS, pointActivityService.searchPointActivities(keyword));
    }

    // BE-16 포인트 활동 목록 정렬 조회
    @Operation(summary = "포인트 활동 목록 정렬 조회")
    @GetMapping("/sort")
    public BaseResponse<PointActivityListResponse> sortPointActivities(@RequestParam String sortType) {
        return new BaseResponse<>(BaseResponseStatus.SUCCESS, pointActivityService.sortPointActivities(sortType));
    }

    // BE-18 포인트 활동 상세 조회
    @Operation(summary = "포인트 활동 상세 조회")
    @GetMapping("/{pointId}")
    public BaseResponse<PointActivityDetailResponse> getPointActivityDetail(@PathVariable Long pointId) {
        return new BaseResponse<>(BaseResponseStatus.SUCCESS, pointActivityService.getPointActivityDetail(pointId));
    }
}
