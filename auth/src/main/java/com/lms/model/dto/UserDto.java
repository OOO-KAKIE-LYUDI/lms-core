package com.lms.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserDto {
    private Long userId;
    private String name;
    private String email;
    private String role;
    private LocalDateTime created;
    private LocalDateTime updated;
}
