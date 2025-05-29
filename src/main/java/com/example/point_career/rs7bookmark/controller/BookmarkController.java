package com.example.point_career.rs7bookmark.controller;

import com.example.point_career.global.response.BaseResponse;
import com.example.point_career.rs7bookmark.dto.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bookmarks")
public class BookmarkController {

    // BE-22 북마크 생성
    @PostMapping
    public BaseResponse<BookmarkResponse> createBookmark(@RequestBody BookmarkCreateRequest request) {
        // TODO: 북마크 생성
        return null;
    }

    // BE-23 북마크 삭제
    @DeleteMapping("/{bookmarkId}")
    public BaseResponse<BookmarkResponse> deleteBookmark(@PathVariable Long bookmarkId) {
        // TODO: 북마크 삭제
        return null;
    }
}