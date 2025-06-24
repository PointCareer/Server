package com.example.point_career.domain.mainpage.service;

import com.example.point_career.domain.mainpage.dto.UserMeResponse;

import com.example.point_career.domain.user.entity.User;

public interface MainPageService {
    UserMeResponse getMe(User user);}
