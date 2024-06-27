package com.lms.core.model.dto.attacment;

import jakarta.validation.constraints.NotNull;

public record AttachmentRequest(@NotNull Long chapterId,
                                @NotNull String name,
                                String type,
                                Long fileId,
                                Integer position) {
}
