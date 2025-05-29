package com.example.point_career.rs7bookmark.service;

import com.example.point_career.rs7bookmark.dto.*;

public interface BookmarkService {
    BookmarkResponse createBookmark(BookmarkCreateRequest request);
    BookmarkResponse deleteBookmark(Long bookmarkId);
}