package com.example.point_career.domain.bookmark.dto;

import com.example.point_career.domain.bookmark.entity.BookmarkType;
import lombok.*;

@Getter @Setter @Builder
public class BookmarkResponse {
    private Long bookmark_id;
    private BookmarkType target_type;
}
