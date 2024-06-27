package com.lms.core.model.dto.attacment;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AttachmentDto {
    private Long attachmentId;
    private Long chapterId;
    private String name;
    private String type;
    private Long fileId;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Integer position;
}
