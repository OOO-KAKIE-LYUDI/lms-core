package com.lms.service;

import com.lms.model.dto.UserDto;
import com.lms.model.entity.UserEntity;

public interface AuthService {
    String login(String username);
    UserEntity register(UserDto userDto, String username, String password);
}
