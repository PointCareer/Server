package com.example.point_career.domain.bookmark.entity;

import com.example.point_career.domain.point.entity.Point;
import com.example.point_career.domain.user.entity.User;
import com.example.point_career.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "PointBookmark")
@Getter
public class PointBookmark extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_bookmark_id")
    private Long id; // 북마크 ID, 기본키

    // 포인트 활동 북마크
    @ManyToOne
    @JoinColumn(name = "point_id")
    private Point point;

    @ManyToOne // 북마크를 한 사용자
    @JoinColumn(name = "user_id")
    private User user;

}
