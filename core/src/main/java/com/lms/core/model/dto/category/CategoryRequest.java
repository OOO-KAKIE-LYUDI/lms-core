package com.lms.core.model.dto.category;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryRequest {

    @NotNull
    private String name;
}
