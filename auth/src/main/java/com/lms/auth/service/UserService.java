package com.lms.auth.service;

import com.lms.auth.model.dto.UserDto;

public interface UserService {
    UserDto getUser(Long userId);
    UserDto getUserByEmail(String email);
}
