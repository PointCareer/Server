package com.example.point_career.domain.tag.entity;

import com.example.point_career.domain.point.entity.Point;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class PointTag {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Point point;

    @ManyToOne
    private Tag tag;
}
