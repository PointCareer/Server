package com.example.point_career.domain.pointrecommend.service;

import com.example.point_career.domain.category.entity.CategoryName;
import com.example.point_career.domain.category.entity.PointCategory;
import com.example.point_career.domain.point.entity.IsPointOnline;
import com.example.point_career.domain.point.entity.Point;
import com.example.point_career.domain.point.repository.PointRepository;
import com.example.point_career.domain.pointrecommend.dto.PointRecommendActivity;
import com.example.point_career.domain.pointrecommend.dto.PointRecommendListResponse;
import com.example.point_career.domain.pointrecommend.dto.RecommendGroup;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointRecommendServiceImpl implements PointRecommendService {

	private final PointRepository pointRepository;

	@Override
	public PointRecommendListResponse recommendList(int requiredPoints, LocalDateTime deadline,
													List<CategoryName> favorite) {
		//모든 포인트 조회
		List<Point> findPoints = pointRepository.findAll();

		//추천 그룹 생성
		List<RecommendGroup> recommendGroups = List.of(
				getCourseA(requiredPoints, deadline, favorite, findPoints),
				getCourseB(requiredPoints, deadline, findPoints)
		);

		//응답 객체 생성 후 변환
		return PointRecommendListResponse.builder()
				.recommendationGroups(recommendGroups)
				.build();
	}

	private RecommendGroup getCourseA(int requiredPoints, LocalDateTime deadline, List<CategoryName> favorite,
									  List<Point> points) {

		// 1. 목표 기간 내 가능한 활동만 필터링
		List<Point> availablePoints = points.stream()
				.filter(p -> !p.getDeadline().isAfter(deadline))
				.collect(Collectors.toList());

		// 2. 관심분야 매칭
		List<Point> filteredPoints = availablePoints.stream()
				.filter(point -> point.getPointCategories().stream()
						.anyMatch(favorite::contains))
				.collect(Collectors.toList());

		// 3. 진로 연계성
		filteredPoints.sort(Comparator
				.comparingInt((Point point) -> calculateCareerScore(point.getPointCategories())).reversed());

		// 4. 포인트 충족
		List<Point> selectedPoints = new ArrayList<>();
		int accumulatedPoints = 0;

		for (Point point : filteredPoints) {
			if (accumulatedPoints >= requiredPoints) {
				break;
			}
			selectedPoints.add(point);
			accumulatedPoints += point.getPointPrice();
		}

		List<PointRecommendActivity> pointRecommendActivities = selectedPoints.stream()
				.map(selectedPoint -> PointRecommendActivity.builder()
						.point_id(selectedPoint.getId())
						.is_point_online(selectedPoint.getIsPointOnlineType())
						.point_duration(selectedPoint.getDuration())
						.point_price(selectedPoint.getPointPrice())
						.point_image_url(selectedPoint.getImageUrl())
						.point_title(selectedPoint.getTitle())
						.point_categories(selectedPoint.getPointCategories())
						.point_link_url(selectedPoint.getLinkUrl())
						.build()
				)
				.toList();

		return RecommendGroup.builder()
				.groupName("A")
				.activities(pointRecommendActivities)
				.build();
	}

	private RecommendGroup getCourseB(int requiredPoints, LocalDateTime deadline, List<Point> points) {
		// 1. 목표 기간 내 가능한 활동만 필터링
		List<Point> availablePoints = points.stream()
				.filter(p -> !p.getDeadline().isAfter(deadline))
				.collect(Collectors.toList());

		// Comparator를 사용하여 정렬 기준 정의
		// 1차 기준: 포인트/시간 효율 (내림차순) → 높은 효율의 활동이 먼저 옴
		// 2차 기준: 온라인 여부 (true 먼저) → 온라인 활동을 우선으로 정렬
		availablePoints.sort(Comparator
				.comparingDouble(
						(Point a) -> (double) a.getPointPrice() / Duration.between(a.getStartTime(), a.getEndTime())
								.toHours()).reversed()
				.thenComparing(a -> -getOnlineTypeScore(a.getIsPointOnlineType())));

		//추천할 활동들을 담을 리스트
		List<Point> selectedPoints = new ArrayList<>();

		//누적 포인트 변수
		int accumulatedPoints = 0;

		//효율 높은 활동부터 순서대로 탐색
		for (Point point : availablePoints) {
			if (accumulatedPoints >= requiredPoints) {
				break;
			}
			selectedPoints.add(point);
			accumulatedPoints += point.getPointPrice();
		}

		List<PointRecommendActivity> pointRecommendActivities = selectedPoints.stream()
				.map(selectedPoint -> PointRecommendActivity.builder()
						.point_id(selectedPoint.getId())
						.is_point_online(selectedPoint.getIsPointOnlineType())
						.point_duration(selectedPoint.getDuration())
						.point_price(selectedPoint.getPointPrice())
						.point_image_url(selectedPoint.getImageUrl())
						.point_title(selectedPoint.getTitle())
						.point_categories(selectedPoint.getPointCategories())
						.point_link_url(selectedPoint.getLinkUrl())
						.build()
				)
				.toList();

		return RecommendGroup.builder()
				.groupName("B")
				.activities(pointRecommendActivities)
				.build();
	}

	private int calculateCareerScore(List<PointCategory> categories) {
		return categories.stream()
				.mapToInt(pointCategory -> getCategoryScore(pointCategory.getCategory().getName()))
				.sum();
	}

	private int getCategoryScore(CategoryName categoryName) {
		switch (categoryName) {
			case CERTIFICATE:
			case RESEARCH_ACADEMIC:
			case CLUB_STARTUP:
				return 3;
			case LANGUAGE:
			case ETC:
				return 2;
			case JOB_PREPARATION:
			case VOLUNTEER:
			case CULTURE_ART:
				return 1;
			default:
				return 0;
		}
	}

	private int getOnlineTypeScore(IsPointOnline onlineType) {
		switch (onlineType) {
			case ONLINE:
				return 3;
			case HYBRID:
				return 2;
			case OFFLINE:
				return 1;
			default:
				return 0;
		}
	}
}
