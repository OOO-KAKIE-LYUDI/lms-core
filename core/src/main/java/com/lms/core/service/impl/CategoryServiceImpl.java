package com.lms.core.service.impl;

import com.lms.core.model.dto.category.CategoryDto;
import com.lms.core.model.dto.category.CategoryRequest;
import com.lms.core.model.entity.CategoryEntity;
import com.lms.core.model.mapper.CategoryMapper;
import com.lms.core.repository.CategoryRepository;
import com.lms.core.service.CategoryService;
import com.lms.core.exception.LmsNotFoundException;
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
        List<CategoryEntity> categories = categoryRepository.findAll();

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
        var categoryEntity = categoryMapper.createCategoryEntity(categoryRequest);
        categoryRepository.save(categoryEntity);
    }

    @Override
    @Transactional
    public void updateCategoryById(Long categoryId, CategoryRequest categoryRequest) {
        var category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new LmsNotFoundException("Not found category by id = <%d>".formatted(categoryId)));

        category.setName(categoryRequest.name());
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
