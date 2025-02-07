package com.lms.algo.model.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProblemDto {
    private Long id;
    private String title;
    private String problemStatement;
    private List<ExampleDto> examples;
    private String constraints;
    private String category;
    private String difficulty;
    private Integer likes;
    private Integer dislikes;
    private String videoId;
}
