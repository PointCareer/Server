package com.example.point_career.domain.bookmark.service;

import com.example.point_career.domain.bookmark.dto.BookmarkCreateRequest;
import com.example.point_career.domain.bookmark.dto.BookmarkResponse;
import com.example.point_career.domain.bookmark.entity.BookmarkType;
import com.example.point_career.domain.user.entity.User;

public interface BookmarkService {
    BookmarkResponse createBookmark(User user, BookmarkCreateRequest request);
    BookmarkResponse deleteBookmark(BookmarkType bookmarkType, Long bookmarkId);
}
