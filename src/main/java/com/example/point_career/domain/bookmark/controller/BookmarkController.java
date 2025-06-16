package com.example.point_career.domain.bookmark.controller;

import com.example.point_career.domain.bookmark.dto.BookmarkCreateRequest;
import com.example.point_career.domain.bookmark.dto.BookmarkResponse;
import com.example.point_career.domain.bookmark.entity.BookmarkType;
import com.example.point_career.domain.bookmark.service.BookmarkServiceImpl;
import com.example.point_career.domain.user.entity.User;
import com.example.point_career.global.common.response.BaseResponse;
import com.example.point_career.global.common.response.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@Tag(name = "RS7: 북마크", description = "포인트/채용 북마크(찜) 생성/삭제 API")
@RestController
@RequestMapping("/api/v1/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkServiceImpl bookmarkService;

    // BE-22 북마크 생성
    @Operation(summary = "북마크 생성")
    @PostMapping
    public BaseResponse<BookmarkResponse> createBookmark(@AuthenticationPrincipal User user, @RequestBody BookmarkCreateRequest request) {
        return new BaseResponse(BaseResponseStatus.CREATE_BOOKMARK_SUCCESS, bookmarkService.createBookmark(user, request));
    }

    // BE-23 북마크 삭제
    @Operation(summary = "북마크 삭제")
    @DeleteMapping("/{bookmarkType}/{bookmarkId}")
    public BaseResponse<BookmarkResponse> deleteBookmark(@PathVariable BookmarkType bookmarkType, @PathVariable Long bookmarkId) {
        return new BaseResponse(BaseResponseStatus.DELETE_BOOKMARK_SUCCESS, bookmarkService.deleteBookmark(bookmarkType, bookmarkId));
    }
}
