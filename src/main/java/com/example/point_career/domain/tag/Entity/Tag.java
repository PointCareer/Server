package com.example.point_career.domain.tag.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 태그 ID, 기본키

    @Enumerated(EnumType.STRING)
    private TagType type; // INDUSTRY, FAVORITE

    private String name; // 태그 이름, 최대 50자
}
