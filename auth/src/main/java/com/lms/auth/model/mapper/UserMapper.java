package com.lms.auth.model.mapper;

import com.lms.auth.model.dto.UserDto;
import com.lms.auth.model.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity createUser(UserDto userDto, String username, String password);

    UserDto createGetUserDto(UserEntity user);
}
