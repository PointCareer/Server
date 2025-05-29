package com.example.point_career.point.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Point")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 포인트 ID, 기본키
    @Column(nullable = false, length = 100)
    private String title; // 포인트활동 제목, 필수 입력, 최대 100자

    private String info; // 프로그램 시간, 장소...
    private String summary; // 포인트 요약,

    private Integer price; // 획득 포인트수량
    private LocalDateTime deadline; // 프로그램 마감일
    private LocalDateTime startTime; // 프로그램 시작일
    private LocalDateTime endTime; // 프로그램 종료일
    private Boolean isPointOnline; // 온라인/오프라인 여부, 기본값은 false
    private String Dept; // 프로그램 주관부서
    private String linkUrl; // 신청 외부 링크
    private String ImageUrl; //
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
