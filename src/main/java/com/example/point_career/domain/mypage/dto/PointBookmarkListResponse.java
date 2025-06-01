package com.example.point_career.domain.mypage.dto;

import lombok.*;
import java.util.List;

/*BE-7*/
@Getter @Setter
public class PointBookmarkListResponse {
    private List<PointBookmark> points;
}
