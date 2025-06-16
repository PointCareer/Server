package com.example.point_career.domain.bookmark.repository;

import com.example.point_career.domain.bookmark.entity.PointBookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointBookmarkRepository extends JpaRepository<PointBookmark, Long> {
    List<PointBookmark> findByUserId(Long userId);
}
