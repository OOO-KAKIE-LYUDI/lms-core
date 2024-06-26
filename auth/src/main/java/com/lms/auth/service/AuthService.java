package com.lms.auth.service;

import com.lms.auth.model.dto.UserDto;
import com.lms.auth.model.entity.UserEntity;

public interface AuthService {
    String login(String email, String password);
    UserDto register(UserDto userDto, String email, String password);
}
