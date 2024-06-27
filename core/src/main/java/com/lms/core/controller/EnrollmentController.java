package com.lms.core.controller;

import com.lms.core.model.dto.enrollment.EnrollmentDto;
import com.lms.core.model.dto.enrollment.EnrollmentRequest;
import com.lms.core.model.dto.enrollment.EnrollmentRequestUpdate;
import com.lms.core.service.EnrollmentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Validated
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @GetMapping
    public List<EnrollmentDto> findAllEnrollments() {
        return enrollmentService.findAllEnrollments();
    }

    @GetMapping("/course/{courseId}")
    public List<EnrollmentDto> findEnrollmentsByCourseId(@PathVariable @NotNull Long courseId) {
        return enrollmentService.findEnrollmentsByCourseId(courseId);
    }

    @GetMapping("/user/{userId}")
    public List<EnrollmentDto> findEnrollmentsByUserId(@PathVariable @NotNull Long userId) {
        return enrollmentService.findEnrollmentsByUserId(userId);
    }

    @GetMapping("/{id}")
    public EnrollmentDto findEnrollmentById(@PathVariable @NotNull Long id) {
        return enrollmentService.findEnrollmentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEnrollmentById(@PathVariable @NotNull Long id) {
        enrollmentService.deleteEnrollmentById(id);
    }

    @PostMapping
    public void postEnrollment(@RequestBody @NotNull @Valid EnrollmentRequest enrollmentRequest) {
        enrollmentService.createEnrollment(enrollmentRequest);
    }

    @PatchMapping("/{id}")
    public void patchEnrollment(@PathVariable @NotNull Long id,
                                @RequestBody @NotNull @Valid EnrollmentRequestUpdate enrollmentRequest) {
        enrollmentService.updateEnrollmentById(id, enrollmentRequest);
    }
}
