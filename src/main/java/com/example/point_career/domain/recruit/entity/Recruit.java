package com.example.point_career.domain.recruit.entity;

import com.example.point_career.domain.bookmark.entity.RecruitBookmark;
import com.example.point_career.domain.Category.entity.RecruitCategory;
import com.example.point_career.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Recruit extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruit_id")
    private Long id; // 모집 ID, 기본키
    @Column(nullable = false, length = 100)
    private String title; // 채용명, 필수 입력, 최대 100자

    @Column(nullable = false, length = 100)
    private String company; // 회사명

    private String type; // 채용 유형 (정규직, 계약직 등)
    private String place; // 근무지
    private LocalDateTime deadline; // 모집 마감일
    private String requirement; // 모집 설명
    private String detail; // 기업소개
    private String linkUrl; // 신청 외부 링크
    private String imageUrl; // 이미지 URL

    @OneToMany(mappedBy = "recruit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecruitCategory> recruitCategories = new ArrayList<>();

    @OneToMany(mappedBy = "recruit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecruitBookmark> recruitBookmarks = new ArrayList<>();

    //연관관계 편의 메서드 만들기

}
