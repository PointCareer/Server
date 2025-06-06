package com.example.point_career.domain.Category.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id; // 카테고리 ID, 기본키

    @Enumerated(EnumType.STRING)
    private CategoryType type; // FAVORITE,ACTIVITY_CATEGORY,RECRUIT_JOB

    @Enumerated(EnumType.STRING)
    private CategoryName name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecruitCategory> recruitCategories = new ArrayList<>();

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PointCategory> pointCategories = new ArrayList<>();

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserCategory> userCategories = new ArrayList<>();


}
