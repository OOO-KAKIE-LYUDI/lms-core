package com.lms.auth.service.impl;

import com.lms.auth.model.dto.UserDto;
import com.lms.auth.model.entity.UserEntity;
import com.lms.auth.model.mapper.UserMapper;
import com.lms.auth.repository.UserRepository;
import com.lms.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto getUser(Long userId) {
        var userEntity = userRepository.findById(userId).orElseThrow();
        return userMapper.createGetUserDto(userEntity);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        var userEntity = userRepository.findUserByEmail(email).orElseThrow();
        return userMapper.createGetUserDto(userEntity);
    }
}
