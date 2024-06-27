package com.lms.core.model.dto.attacment;

public record AttachmentRequestUpdate(String name,
                                      String type,
                                      Long fileId,
                                      Integer position) {
}
