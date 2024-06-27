package com.lms.core.repository;

import com.lms.core.model.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

    List<CourseEntity> findByCategoryEntityName(String category);
}
