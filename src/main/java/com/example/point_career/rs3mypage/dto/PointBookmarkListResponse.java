package com.example.point_career.rs3mypage.dto;

import lombok.*;
import java.util.List;

/*BE-7*/
@Getter @Setter
public class PointBookmarkListResponse {
    private List<PointBookmark> points;
}