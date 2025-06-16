package com.example.point_career.domain.mypage.repository;

import com.example.point_career.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyPageRepository extends JpaRepository<User, Long> {
    // 마이페이지 특화 쿼리 메서드가 필요한 경우 여기에 추가
}