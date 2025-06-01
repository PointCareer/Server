package com.example.point_career.domain.bookmark.service;

import com.example.point_career.domain.bookmark.dto.BookmarkCreateRequest;
import com.example.point_career.domain.bookmark.dto.BookmarkResponse;

public interface BookmarkService {
    BookmarkResponse createBookmark(BookmarkCreateRequest request);
    BookmarkResponse deleteBookmark(Long bookmarkId);
}
