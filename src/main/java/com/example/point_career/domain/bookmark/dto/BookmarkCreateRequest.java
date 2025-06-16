package com.example.point_career.domain.bookmark.dto;

import com.example.point_career.domain.bookmark.entity.BookmarkType;
import lombok.*;

@Getter @Setter
public class BookmarkCreateRequest {
    private Long id;
    private BookmarkType target_type;
}
