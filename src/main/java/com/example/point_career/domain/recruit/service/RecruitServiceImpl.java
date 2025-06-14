package com.example.point_career.domain.recruit.service;

import com.example.point_career.domain.category.entity.CategoryType;
import com.example.point_career.domain.recruit.dto.RecruitDetailResponse;
import com.example.point_career.domain.recruit.dto.RecruitListResponse;
import com.example.point_career.domain.recruit.entity.Recruit;
import com.example.point_career.domain.recruit.repository.RecruitRepository;
import com.example.point_career.global.common.exception.CustomException;
import com.example.point_career.global.common.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RecruitServiceImpl implements RecruitService {

    private final RecruitRepository recruitRepository;

    // BE-19: 교내 추천 채용 목록 조회
    @Override
    public RecruitListResponse getRecruits() {
        List<Recruit> all = recruitRepository.findAll();
        return buildRecruitListResponse(all);
    }

    // BE-20: 교내 추천 채용 정렬 조회
    @Override
    public RecruitListResponse getRecruitsSorted(String sortType) {
        Sort sort;
        if ("deadline".equalsIgnoreCase(sortType)) {
            // 마감일 오름차순
            sort = Sort.by("deadline").ascending();
        } else {
            // 기본: 생성일(createdAt) 내림차순 → 최신순
            sort = Sort.by(Sort.Direction.DESC, "createdAt");
        }
        List<Recruit> sortedRecruits = recruitRepository.findAll(sort);
        return buildRecruitListResponse(sortedRecruits);
    }

    // BE-22: 채용 공고 검색 기능
    @Override
    public RecruitListResponse searchRecruits(String keyword) {
        List<Recruit> found = recruitRepository
                .findByTitleContainingOrCompanyContaining(keyword, keyword);
        return buildRecruitListResponse(found);
    }

    // 공통 매핑 로직: List<Recruit> → RecruitListResponse
    private RecruitListResponse buildRecruitListResponse(List<Recruit> recruits) {
        List<RecruitListResponse.RecruitDto> dtos = recruits.stream()
                .map(r -> {
                    // Favorite 카테고리 이름만
                    List<String> favorites = r.getRecruitCategories().stream()
                            .map(rc -> rc.getCategory())
                            .filter(c -> c.getType() == CategoryType.FAVORITE)
                            .map(c -> c.getName().toString())
                            .collect(Collectors.toList());

                    // RecruitJob 카테고리 이름만
                    List<String> jobs = r.getRecruitCategories().stream()
                            .map(rc -> rc.getCategory())
                            .filter(c -> c.getType() == CategoryType.RECRUIT_JOB)
                            .map(c -> c.getName().toString())
                            .collect(Collectors.toList());

                    return RecruitListResponse.RecruitDto.builder()
                            .recruitId(r.getId())
                            .recruitName(r.getTitle())
                            .recruitCompany(r.getCompany())
                            .recruitDeadline(r.getDeadline())
                            .recruitImageUrl(r.getImageUrl())
                            .favoriteCategories(favorites)
                            .recruitJobCategories(jobs)
                            .build();
                })
                .collect(Collectors.toList());

        return RecruitListResponse.builder()
                .recruits(dtos)
                .build();
    }

    // BE-21: 교내 추천 채용 상세 조회
    @Override
    public RecruitDetailResponse getRecruitDetail(Long recruitId) {
        Recruit r = recruitRepository.findById(recruitId)
                .orElseThrow(() -> new CustomException(ErrorCode.RECRUIT_NOT_FOUND));

        // RecruitJob 카테고리 이름만
        List<String> jobs = r.getRecruitCategories().stream()
                .map(rc -> rc.getCategory())
                .filter(c -> c.getType() == CategoryType.RECRUIT_JOB)
                .map(c -> c.getName().toString())
                .collect(Collectors.toList());

        var detailDto = RecruitDetailResponse.RecruitDetailDto.builder()
                .recruitId(r.getId())
                .recruitName(r.getTitle())
                .recruitCompany(r.getCompany())
                .recruitDeadline(r.getDeadline())
                .recruitPlace(r.getPlace())
                .recruitDetail(r.getDetail())
                .recruitType(r.getType().toString())
                .recruitJobCategories(jobs)
                .recruitImageUrl(r.getImageUrl())
                .recruitLinkUrl(r.getLinkUrl())
                .createdAt(r.getCreatedAt())
                .updatedAt(r.getUpdatedAt())
                .build();

        return RecruitDetailResponse.builder()
                .recruit(detailDto)
                .build();
    }
}