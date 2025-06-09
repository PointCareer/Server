package com.example.point_career.domain.user.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.point_career.domain.bookmark.entity.PointBookmark;
import com.example.point_career.domain.bookmark.entity.RecruitBookmark;
import com.example.point_career.domain.category.entity.UserCategory;
import com.example.point_career.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id; //회원id pk

    @Column(nullable = false, length = 10)
    private String name; //회원 이름

    @Column(nullable = false, length = 50, unique = true)
    private String loginId; //회원 로그인 아이디, 유니크 제약조건

    @Column(nullable = false, length = 100)
    private String password; //회원 비밀번호, 암호화 저장

    @Column(nullable = false, length = 100, unique = true)
    private String email; //회원 이메일, 유니크 제약조건

    private String major; //회원 전공
    private int grade; //회원 학년, 1~5학년
    private String semester; //회원 학기, 1학기, 2학기, 여름방학, 겨울방학 등

    private Boolean emailVerified; //이메일 인증 여부, 기본값은 false
    private int userPoint; //현재 보유 포인트, 기본값은 0
    private int remainPoint; //잔여 포인트, 기본값은 0
    private LocalDate targetPeriod;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecruitBookmark> recruitBookmarks = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PointBookmark> pointBookmarks = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserCategory> userCategories = new ArrayList<>(); // 유저가 선택한 카테고리 목록

}
