package com.lms.algo.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProblemSummaryDto {
    private String id;
    private String title;
    private String difficulty;
    private String category;
    private String link;
    private String videoId;
    private int likes;
    private int dislikes;
    private int order;
}

