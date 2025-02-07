package com.lms.algo.model.dto;

import lombok.Data;

@Data
public class CreateSubmissionDto {

    private Long problemId;
    private String code;
    private String language;
    private Long userId;
}
