package com.example.point_career.domain.bookmark.repository;

import com.example.point_career.domain.bookmark.entity.PointBookmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PointBookmarkRepository extends JpaRepository<PointBookmark, Long> {
    List<PointBookmark> findByUserId(Long userId);
}

