package com.example.point_career.domain.bookmark.repository;

import com.example.point_career.domain.bookmark.entity.RecruitBookmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecruitBookmarkRepository extends JpaRepository<RecruitBookmark, Long> {
    List<RecruitBookmark> findByUserId(Long userId);
}
