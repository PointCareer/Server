package com.example.point_career.domain.bookmark.repository;

import com.example.point_career.domain.bookmark.entity.RecruitBookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitBookmarkRepository extends JpaRepository<RecruitBookmark, Long> {
}
