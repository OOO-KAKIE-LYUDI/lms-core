package com.lms.auth.model.mapper;

import com.lms.auth.model.dto.RegisterUserDto;
import com.lms.auth.model.dto.UserDto;
import com.lms.auth.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

//    @Mappings({
//            @Mapping(target = "name", source = "userDto.name"),
//    })
    UserEntity createUser(RegisterUserDto userDto, String email, String password);

    UserDto createGetUserDto(UserEntity user);
}
