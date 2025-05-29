package com.example.point_career.tag.Entity;

import com.example.point_career.point.Entity.Point;
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
