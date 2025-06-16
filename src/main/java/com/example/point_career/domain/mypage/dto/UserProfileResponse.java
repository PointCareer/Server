package com.example.point_career.domain.mypage.dto;

import com.example.point_career.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResponse {
    private ProfileDto profile;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProfileDto {
        private String userName;
        private String userMajor;
        private Integer userGrade;
        private String userEmail;
        private String userLoginId;
        private List<String> favorites;
        private List<String> activityCategories;

        public static ProfileDto User(User user) {
            return ProfileDto.builder()
                    .userName(user.getName())
                    .userMajor(user.getMajor())
                    .userGrade(user.getGrade())
                    .userEmail(user.getEmail())
                    .userLoginId(user.getLoginId())
                    .favorites(user.getUserCategories().stream()
                            .map(userCategory -> userCategory.getCategory().getName().toString())
                            .collect(Collectors.toList()))
                    .activityCategories(getActivityCategoryNames(user))
                    .build();
        }



        private static List<String> getActivityCategoryNames(User user) {
            // 예시: user.getActivityCategories()가 List<CategoryName>을 반환한다고 가정
            return user.getUserCategories().stream()
                    .map(categoryName -> categoryName.toString())
                    .collect(Collectors.toList());
        }
    }

    public static UserProfileResponse User(User user) {
        return UserProfileResponse.builder()
                .profile(ProfileDto.User(user))
                .build();
    }
}

