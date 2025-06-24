package com.example.point_career.domain.mainpage.service;

import com.example.point_career.domain.mainpage.dto.UserMeResponse;
import com.example.point_career.domain.user.entity.User;
import com.example.point_career.domain.user.repository.UserRepository;
import com.example.point_career.global.common.response.BaseException;
import com.example.point_career.global.common.response.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainPageServiceImpl implements MainPageService {

    private final UserRepository userRepository;

    @Override
    public UserMeResponse getMe(User user) {
        User findUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.USER_NOT_EXIST));
        UserMeResponse response = new UserMeResponse();
        response.setLogin_id(findUser.getLoginId());
        response.setUser_name(findUser.getName());
        return response;
    }
}