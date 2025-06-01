package com.example.point_career.domain.user.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Integer grade; //회원 학년, 1~5학년
    private String semester; //회원 학기, 1학기, 2학기, 여름방학, 겨울방학 등

    private Boolean emailVerified; //이메일 인증 여부, 기본값은 false
    private Integer userPoint; //현재 보유 포인트, 기본값은 0
    private Integer remainPoint; //잔여 포인트, 기본값은 0

    private LocalDateTime createdAt; //회원 가입 일시, 기본값은 현재 시간
    private LocalDateTime updatedAt; //회원 정보 수정 일시, 기본값은 현재 시간
}
