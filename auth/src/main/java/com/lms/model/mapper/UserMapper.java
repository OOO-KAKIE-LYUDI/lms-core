package com.lms.model.mapper;

import com.lms.model.dto.UserDto;
import com.lms.model.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity createUser(UserDto userDto, String username, String password);

    UserDto createGetUserDto(UserEntity user);
}
