package com.example.point_career.domain.bookmark.entity;

import com.example.point_career.domain.recruit.entity.Recruit;
import com.example.point_career.domain.user.entity.User;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "RecruitBookmark")
public class RecruitBookmark {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 북마크 ID, 기본키

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne // 북마크를 한 사용자
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "recruit_id")
    private Recruit recruit;
}

