package com.example.point_career.domain.point.entity;

import com.example.point_career.domain.bookmark.entity.PointBookmark;
import com.example.point_career.domain.Category.entity.PointCategory;
import com.example.point_career.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Point extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_id")
    private Long id; // 포인트 ID, 기본키

    @Column(nullable = false, length = 100)
    private String title; // 포인트활동 제목, 필수 입력, 최대 100자

    private String info; // 프로그램 시간, 장소...
    private LocalDateTime deadline; // 프로그램 마감일

    private LocalDateTime startTime; // 프로그램 시작일
    private LocalDateTime endTime; // 프로그램 종료일

    private String place; // 프로그램 장소, 최대 100자
    private String dept; // 프로그램 주관부서

    @Enumerated(EnumType.STRING)
    private PointDuration duration; // 포인트 소요시간

    @Enumerated(EnumType.STRING)
    private IsPointOnline isPointOnlineType;

    private Integer pointPrice; // 포인트 지급량, 필수 입력, 0 이상

    private String linkUrl; // 신청 외부 링크
    private String ImageUrl; //

    @OneToMany(mappedBy = "point", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PointBookmark> pointBookmarks = new ArrayList<>();

    @OneToMany(mappedBy = "point", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PointCategory> pointCategories = new ArrayList<>();

}
