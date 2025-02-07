package com.lms.algo.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestCaseDto {
    private Long id;
    private String input;
    private String expectedOutput;
}

