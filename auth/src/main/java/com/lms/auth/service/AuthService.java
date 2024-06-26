package com.lms.auth.service;

import com.lms.auth.model.dto.UserDto;
import com.lms.auth.model.entity.UserEntity;

public interface AuthService {
    String login(String username);
    UserEntity register(UserDto userDto, String username, String password);
}
