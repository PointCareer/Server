package com.example.point_career.domain.point.repository;

import com.example.point_career.domain.point.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {

}
