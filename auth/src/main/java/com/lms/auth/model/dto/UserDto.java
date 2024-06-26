package com.lms.auth.model.dto;

public record UserDto (Long userId, String name, String email, String role, String created, String updated){
}
