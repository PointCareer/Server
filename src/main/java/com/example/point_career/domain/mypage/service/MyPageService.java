package com.example.point_career.domain.mypage.service;

import com.example.point_career.domain.bookmark.repository.PointBookmarkRepository;
import com.example.point_career.domain.bookmark.repository.RecruitBookmarkRepository;
import com.example.point_career.domain.category.entity.Category;
import com.example.point_career.domain.category.entity.UserCategory;
import com.example.point_career.domain.mypage.dto.*;
import com.example.point_career.domain.user.entity.User;
import com.example.point_career.domain.user.repository.UserRepository;
import com.example.point_career.global.common.response.BaseException;
import com.example.point_career.global.common.response.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.point_career.domain.category.entity.CategoryType;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MyPageService {
    private final UserRepository userRepository;
    private final PointBookmarkRepository pointBookmarkRepository;
    private final RecruitBookmarkRepository recruitBookmarkRepository;

    public MyPageResponse getMyPage(Long userId) {
        // 1) 유저 프로필
        User u = userRepository.findById(userId)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.USER_NOT_EXIST));
        MyPageResponse.ProfileDto profile = MyPageResponse.ProfileDto.builder()
                .userName(u.getName())
                .userMajor(u.getMajor())
                .userGrade(u.getGrade())
                .userEmail(u.getEmail())
                .userLoginId(u.getLoginId())
                .build();

        // 2) 포인트 북마크
        List<MyPageResponse.PointDto> points = pointBookmarkRepository.findByUserId(userId).stream()
                .map(pb -> {
                    var p = pb.getPoint();
                    List<String> fav = p.getPointCategories().stream()
                            .map(pc -> pc.getCategory())
                            .filter(c->c.getType()==CategoryType.FAVORITE)
                            .map(c->c.getName().toString()).toList();
                    List<String> act = p.getPointCategories().stream()
                            .map(pc -> pc.getCategory())
                            .filter(c->c.getType()==CategoryType.ACTIVITY_CATEGORY)
                            .map(c->c.getName().toString()).toList();
                    return MyPageResponse.PointDto.builder()
                            .pointId(p.getId())
                            .pointName(p.getTitle())
                            .pointDeadline(p.getDeadline())
                            .pointPrice(p.getPointPrice())
                            .pointImageUrl(p.getImageUrl())
                            .favoriteCategories(fav)
                            .activityCategories(act)
                            .build();
                }).toList();

        // 3) 채용 북마크
        List<MyPageResponse.RecruitDto> recruits = recruitBookmarkRepository.findByUserId(userId).stream()
                .map(rb -> {
                    var r = rb.getRecruit();
                    List<String> fav = r.getRecruitCategories().stream()
                            .map(rc->rc.getCategory())
                            .filter(c->c.getType()==CategoryType.FAVORITE)
                            .map(c->c.getName().toString()).toList();
                    List<String> jobs = r.getRecruitCategories().stream()
                            .map(rc->rc.getCategory())
                            .filter(c->c.getType()==CategoryType.RECRUIT_JOB)
                            .map(c->c.getName().toString()).toList();
                    return MyPageResponse.RecruitDto.builder()
                            .recruitId(r.getId())
                            .recruitName(r.getTitle())
                            .recruitCompany(r.getCompany())
                            .recruitDeadline(r.getDeadline())
                            .recruitImageUrl(r.getImageUrl())
                            .favoriteCategories(fav)
                            .recruitJobCategories(jobs)
                            .build();
                }).toList();

        return MyPageResponse.builder()
                .profile(profile)
                .points(points)
                .recruits(recruits)
                .build();
    }

    // 4. 프로필 수정
    @Transactional
    public UserProfileUpdateResponse updateProfile(UserProfileUpdateRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAIL));
        user.setMajor(request.getMajor());
        user.setGrade(request.getGrade());
        user.setSemester(request.getSemester());

        user.getUserCategories().clear();

        // 요청받은 favorite(Category ENUM)으로 UserCategory 새로 추가
        if (request.getFavorite() != null) {
            for (Category category : request.getFavorite()) {
                UserCategory userCategory = UserCategory.builder()
                        .user(user)
                        .category(category)
                        .build();
                user.getUserCategories().add(userCategory);
            }
        }

        return UserProfileUpdateResponse.builder()
                .userId(user.getId())
                .major(user.getMajor())
                .grade(user.getGrade())
                .favorite(request.getFavorite())
                .build();
    }
}