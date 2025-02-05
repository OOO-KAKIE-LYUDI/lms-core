package com.lms.algo.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExampleDto {
    private Long id;
    private String inputText;
    private String outputText;
    private String explanation;
    private String img;
}
