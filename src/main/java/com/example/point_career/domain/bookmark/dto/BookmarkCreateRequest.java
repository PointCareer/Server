package com.example.point_career.domain.bookmark.dto;

import lombok.*;

@Getter @Setter
public class BookmarkCreateRequest {
    private Long id;
    private String target_type;
}
