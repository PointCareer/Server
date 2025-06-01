package com.example.point_career.domain.point.controller;

import com.example.point_career.global.response.BaseResponse;
import com.example.point_career.domain.point.dto.PointActivityDetailResponse;
import com.example.point_career.domain.point.dto.PointActivityListResponse;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@Tag(name = "RS5: 포인트 활동", description = "포인트 활동 전체/검색/필터/상세 조회 API")
@RestController
@RequestMapping("/api/v1/points/activities")
public class PointActivityController {

    // BE-14 포인트 활동 목록 조회
    @Operation(summary = "포인트 활동 목록 조회")
    @GetMapping
    public BaseResponse<PointActivityListResponse> getPointActivities() {
        // TODO: 전체 포인트 활동 목록 조회
        return null;
    }

    // BE-15 포인트 활동 검색
    @Operation(summary = "포인트 활동 검색")
    @GetMapping("/search")
    public BaseResponse<PointActivityListResponse> searchPointActivities(@RequestParam String keyword) {
        // TODO: 키워드로 포인트 활동 검색
        return null;
    }

    // BE-17 포인트 활동 목록 필터링 조회 (정렬/필터 통합 시 예: ?filter=, ?sort=)
    @Operation(summary = "포인트 활동 목록 필터링 조회")
    @GetMapping("/filter")
    public BaseResponse<PointActivityListResponse> filterPointActivities(@RequestParam(required = false) String filter,
                                                                         @RequestParam(required = false) String sort) {
        // TODO: 포인트 활동 필터링 및 정렬
        return null;
    }

    // BE-18 포인트 활동 상세 조회
    @Operation(summary = "포인트 활동 상세 조회")
    @GetMapping("/{pointId}")
    public BaseResponse<PointActivityDetailResponse> getPointActivityDetail(@PathVariable Long pointId) {
        // TODO: 포인트 활동 상세 조회
        return null;
    }
}
