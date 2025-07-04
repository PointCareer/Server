package com.example.point_career.domain.recruit.repository;

import com.example.point_career.domain.recruit.entity.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecruitRepository extends JpaRepository<Recruit, Long> {
    List<Recruit> findByTitleContainingOrCompanyContaining(String title, String company);
}