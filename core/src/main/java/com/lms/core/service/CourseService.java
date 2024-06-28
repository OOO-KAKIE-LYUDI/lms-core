package com.lms.core.service;

import com.lms.core.model.dto.course.CourseDto;
import com.lms.core.model.dto.course.CourseRequest;
import com.lms.core.model.dto.course.CourseRequestUpdate;

import java.util.List;

public interface CourseService {
    List<CourseDto> findAllCourses();

    CourseDto findCourseById(Long categoryId);

    List<CourseDto> findAllByCreatorId(Long userId);

    List<CourseDto> findCourseByCategory(String category);

    void createCourse(CourseRequest courseRequest);

    void updateCourseById(Long categoryId, CourseRequestUpdate courseRequest);

    void deleteCourseById(Long categoryId);
}
