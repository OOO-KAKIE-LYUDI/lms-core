package com.lms.core.controller;

import com.lms.core.model.dto.category.CategoryDto;
import com.lms.core.model.dto.category.CategoryRequest;
import com.lms.core.service.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    List<CategoryDto> findAll() {
        return categoryService.findAllCategories();
    }

    @GetMapping("/{id}")
    CategoryDto findById(@PathVariable @NotNull Long id) {
        return categoryService.findCategoryById(id);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable @NotNull Long id) {
        categoryService.deleteCategoryById(id);
    }

    @PostMapping
    void postCategory(@RequestBody
                      @NotNull
                      @Valid
                      CategoryRequest categoryRequest) {
        categoryService.createCategory(categoryRequest);
    }

    @PatchMapping("/{id}")
    void patchCategory(@PathVariable
                       @NotNull
                       Long id,
                       @RequestBody
                       @NotNull
                       @Valid
                       CategoryRequest categoryRequest) {
        categoryService.updateCategoryById(id, categoryRequest);
    }
}
