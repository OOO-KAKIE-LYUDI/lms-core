package com.lms.core.service.impl;

import com.lms.core.exception.LmsNotFoundException;
import com.lms.core.model.dto.course.CourseDto;
import com.lms.core.model.dto.course.CourseRequest;
import com.lms.core.model.dto.course.CourseRequestPatch;
import com.lms.core.model.mapper.CourseMapper;
import com.lms.core.repository.CourseRepository;
import com.lms.core.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public List<CourseDto> findAllCourses() {
        var courses = courseRepository.findAll();

        if (CollectionUtils.isEmpty(courses)) {
            throw new LmsNotFoundException("Не найдено ни одного курса");
        }

        return courses.stream().map(courseMapper::toDto).toList();
    }

    @Override
    public CourseDto findCourseById(Long courseId) {
        var course = courseRepository.findById(courseId)
                .orElseThrow(() -> new LmsNotFoundException("Не найдено ни одного курса с <courseId>=%d".formatted(courseId)));

        return courseMapper.toDto(course);
    }

    @Override
    public List<CourseDto> findAllByCreatorId(Long userId) {
        var courses = courseRepository.findByCreatorId(userId);

        if (CollectionUtils.isEmpty(courses)) {
            throw new LmsNotFoundException("Не найдено ни одного курса с <userId>=%d".formatted(userId));
        }

        return courses.stream().map(courseMapper::toDto).toList();
    }

    @Override
    public List<CourseDto> findCourseByCategory(String category) {
        var courses = courseRepository.findByCategoryEntityName(category);

        if (CollectionUtils.isEmpty(courses)) {
            throw new LmsNotFoundException("Не найдено ни одного курса c <categoryName>=%s".formatted(category));
        }

        return courses.stream().map(courseMapper::toDto).toList();
    }

    @Override
    public void createCourse(CourseRequest courseRequest) {
        var categoryEntity = courseMapper.toEntity(courseRequest);
        courseRepository.save(categoryEntity);
    }

    @Override
    @Transactional
    public void updateCourseById(Long courseId, CourseRequestPatch courseRequest) {
        var course = courseRepository.findById(courseId)
                .orElseThrow(() -> new LmsNotFoundException("Не найдено ни одного курса с <courseId>=%d".formatted(courseId)));

        courseMapper.updateCourseEntity(course, courseRequest);
    }

    @Override
    public void deleteCourseById(Long courseId) {
        if (!courseRepository.existsById(courseId)) {
            throw new LmsNotFoundException("Не найдено ни одного курса c <courseId>=%d".formatted(courseId));
        }
        courseRepository.deleteById(courseId);
    }
}
