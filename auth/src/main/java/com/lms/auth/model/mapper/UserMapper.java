package com.lms.auth.model.mapper;

import com.lms.auth.model.dto.RegisterUserDto;
import com.lms.auth.model.dto.UserDto;
import com.lms.auth.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(target = "name", source = "userDto.name"),
            @Mapping(target = "role", source = "userDto.role"),
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "password", source = "password")
    })
    UserEntity createUser(RegisterUserDto userDto, String email, String password);

    @Mappings({
            @Mapping(target = "userId", source = "userId"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "role", source = "role"),
            @Mapping(target = "created", source = "createdAt"),
            @Mapping(target = "updated", source = "updatedAt"),
    })
    UserDto createGetUserDto(UserEntity user);
}
