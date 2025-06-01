package com.example.point_career.domain.recruit.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Recruit")
public class Recruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 모집 ID, 기본키

    @Column(nullable = false, length = 100)
    private String title; // 채용명, 필수 입력, 최대 100자

    private String company; // 회사명
    private LocalDateTime deadline; // 모집 마감일
    private String detail; // 모집 설명
    private String linkUrl; // 신청 외부 링크
    private String imageUrl; // 이미지 URL
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
