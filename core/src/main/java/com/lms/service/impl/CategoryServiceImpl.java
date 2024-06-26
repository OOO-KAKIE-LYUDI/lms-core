package com.lms.service.impl;

import com.lms.exception.LmsNotFoundException;
import com.lms.model.dto.category.CategoryDto;
import com.lms.model.dto.category.CategoryRequest;
import com.lms.model.entity.Category;
import com.lms.model.mapper.CategoryMapper;
import com.lms.repository.CategoryRepository;
import com.lms.service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> findAllCategories() {
        List<Category> categories = categoryRepository.findAll();

        if (CollectionUtils.isEmpty(categories)) {
            throw new LmsNotFoundException("Not found categories");
        }

        return categories.stream().map(categoryMapper::createCategoryDto).toList();
    }

    @Override
    public CategoryDto findCategoryById(Long categoryId) {
        var category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new LmsNotFoundException("Not found category by id = <%d>".formatted(categoryId)));

        return categoryMapper.createCategoryDto(category);
    }

    @Override
    public void createCategory(CategoryRequest categoryRequest) {
        Category category = categoryMapper.createCategory(categoryRequest);
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void updateCategoryById(Long categoryId, CategoryRequest categoryRequest) {
        var category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new LmsNotFoundException("Not found category by id = <%d>".formatted(categoryId)));

        category.setName(categoryRequest.getName());
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
