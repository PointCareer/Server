package com.example.point_career.domain.point.repository;

import com.example.point_career.domain.point.entity.Point;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {
    List<Point> findByTitleContainingIgnoreCase(String keyword);
    List<Point> findAll(Sort sort);
}