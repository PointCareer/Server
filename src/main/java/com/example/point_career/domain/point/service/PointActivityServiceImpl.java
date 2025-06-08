package com.example.point_career.domain.point.service;

import com.example.point_career.domain.point.dto.PointActivity;
import com.example.point_career.domain.point.dto.PointActivityDetail;
import com.example.point_career.domain.point.dto.PointActivityDetailResponse;
import com.example.point_career.domain.point.dto.PointActivityListResponse;
import com.example.point_career.domain.point.entity.Point;
import com.example.point_career.domain.point.repository.PointRepository;
import com.example.point_career.global.common.response.BaseException;
import com.example.point_career.global.common.response.BaseResponseStatus;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointActivityServiceImpl implements PointActivityService {

    private final PointRepository pointRepository;

    private PointActivity toPointActivity(Point point) {
        PointActivity dto = new PointActivity();
        dto.setPoint_id(point.getId());
        dto.setPoint_title(point.getTitle());
        dto.setPoint_price(point.getPointPrice() == null ? 0 : point.getPointPrice());
        dto.setPoint_deadline(point.getDeadline() == null ? null : point.getDeadline().toString());
        dto.setPoint_duration(point.getDuration() == null ? 0 : point.getDuration().ordinal());
        dto.setPoint_online(point.getIsPointOnlineType() != null);
        dto.setActivity_category(point.getPointCategories().stream()
                .map(pc -> pc.getCategory().getId())
                .collect(Collectors.toList()));
        return dto;
    }

    private PointActivityDetail toPointActivityDetail(Point point) {
        PointActivityDetail detail = new PointActivityDetail();
        detail.setPoint_id(point.getId());
        detail.setPoint_title(point.getTitle());
        detail.setPoint_online(point.getIsPointOnlineType() != null);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        detail.setPoint_start_time(point.getStartTime() == null ? null : point.getStartTime().format(formatter));
        detail.setPoint_end_time(point.getEndTime() == null ? null : point.getEndTime().format(formatter));
        detail.setPoint_price(point.getPointPrice() == null ? 0 : point.getPointPrice());
        detail.setPoint_duration(point.getDuration() == null ? 0 : point.getDuration().ordinal());
        detail.setActivity_category(point.getPointCategories().stream()
                .map(pc -> pc.getCategory().getId())
                .collect(Collectors.toList()));
        detail.setPoint_image_url(point.getImageUrl());
        detail.setPoint_link_url(point.getLinkUrl());
        return detail;
    }

    @Override
    public PointActivityListResponse getPointActivities() {
        List<PointActivity> activities = pointRepository.findAll().stream()
                .map(this::toPointActivity)
                .collect(Collectors.toList());
        PointActivityListResponse response = new PointActivityListResponse();
        response.setPoints(activities);
        return response;
    }

    @Override
    public PointActivityListResponse searchPointActivities(String keyword) {
        List<PointActivity> activities = pointRepository.findByTitleContainingIgnoreCase(keyword).stream()
                .map(this::toPointActivity)
                .collect(Collectors.toList());
        PointActivityListResponse response = new PointActivityListResponse();
        response.setPoints(activities);
        return response;
    }

    @Override
    public PointActivityListResponse sortPointActivities(String sortType) {
        Sort s = Sort.unsorted();
        if (sortType != null) {
            switch (sortType) {
                case "deadline":
                    s = Sort.by(Sort.Direction.ASC, "deadline");
                    break;
                case "priceDesc":
                    s = Sort.by(Sort.Direction.DESC, "pointPrice");
                    break;
                case "durationAsc":
                    s = Sort.by(Sort.Direction.ASC, "duration");
                    break;
            }
        }
        List<PointActivity> activities = pointRepository.findAll(s).stream()
                .map(this::toPointActivity)
                .collect(Collectors.toList());
        PointActivityListResponse response = new PointActivityListResponse();
        response.setPoints(activities);
        return response;
    }

    @Override
    public PointActivityDetailResponse getPointActivityDetail(Long pointId) {
        Point point = pointRepository.findById(pointId)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAIL));
        PointActivityDetailResponse response = new PointActivityDetailResponse();
        response.setPoint(toPointActivityDetail(point));
        return response;
    }
}