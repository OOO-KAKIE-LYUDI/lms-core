package com.lms.service.impl;

import com.lms.repository.CategoryRepository;
import com.lms.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public void findAll() {
        categoryRepository.findAll();
    }

    @Override
    public void findById() {
        throw new NotImplementedException();
    }

    @Override
    public void create() {
        throw new NotImplementedException();
    }

    @Override
    public void update() {
        throw new NotImplementedException();
    }

    @Override
    public void delete() {
        throw new NotImplementedException();
    }
}
