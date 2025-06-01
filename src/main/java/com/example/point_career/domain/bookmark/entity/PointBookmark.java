package com.example.point_career.domain.bookmark.entity;

import com.example.point_career.domain.point.entity.Point;
import com.example.point_career.domain.user.entity.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "PointBookmark")
public class PointBookmark {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 북마크 ID, 기본키

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne // 북마크를 한 사용자
    @JoinColumn(name = "user_id")
    private User user;

    // 포인트 활동 북마크
    @ManyToOne
    @JoinColumn(name = "point_id")
    private Point point;

}
