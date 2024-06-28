package com.lms.core.controller;

import com.lms.core.model.dto.course.CourseDto;
import com.lms.core.model.dto.course.CourseRequest;
import com.lms.core.model.dto.course.CourseRequestPatch;
import com.lms.core.service.CourseService;
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
@RequestMapping("/api/courses")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    List<CourseDto> findAllCourses() {
        return courseService.findAllCourses();
    }

    @GetMapping("/{id}")
    CourseDto findCourseById(@PathVariable @NotNull Long id) {
        return courseService.findCourseById(id);
    }

    @GetMapping("/user/{id}")
    List<CourseDto> findAllCourses(@PathVariable @NotNull Long id) {
        return courseService.findAllByCreatorId(id);
    }

    @GetMapping("/category/{category}")
    List<CourseDto> findCourseByCategory(@PathVariable String category) {
        return courseService.findCourseByCategory(category);
    }

    @DeleteMapping("/{id}")
    void deleteCourseById(@PathVariable @NotNull Long id) {
        courseService.deleteCourseById(id);
    }

    @PostMapping
    void postCourse(@RequestBody
                    @NotNull
                    @Valid
                    CourseRequest courseRequest) {
        courseService.createCourse(courseRequest);
    }

    @PatchMapping("/{id}")
    void patchCourse(@PathVariable
                     @NotNull
                     Long id,
                     @RequestBody
                     @NotNull
                     @Valid
                     CourseRequestPatch courseRequest) {
        courseService.updateCourseById(id, courseRequest);
    }
}
