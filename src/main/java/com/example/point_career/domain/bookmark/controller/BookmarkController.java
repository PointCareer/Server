package com.example.point_career.domain.bookmark.controller;

import com.example.point_career.domain.bookmark.dto.BookmarkCreateRequest;
import com.example.point_career.domain.bookmark.dto.BookmarkResponse;
import com.example.point_career.global.response.BaseResponse;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@Tag(name = "RS7: 북마크", description = "포인트/채용 북마크(찜) 생성/삭제 API")
@RestController
@RequestMapping("/api/v1/bookmarks")
public class BookmarkController {

    // BE-22 북마크 생성
    @Operation(summary = "북마크 생성")
    @PostMapping
    public BaseResponse<BookmarkResponse> createBookmark(@RequestBody BookmarkCreateRequest request) {
        // TODO: 북마크 생성
        return null;
    }

    // BE-23 북마크 삭제
    @Operation(summary = "북마크 삭제")
    @DeleteMapping("/{bookmarkId}")
    public BaseResponse<BookmarkResponse> deleteBookmark(@PathVariable Long bookmarkId) {
        // TODO: 북마크 삭제
        return null;
    }
}
