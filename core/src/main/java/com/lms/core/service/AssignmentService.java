package com.lms.core.service;

import com.lms.core.model.dto.assignment.AssignmentDto;
import com.lms.core.model.dto.assignment.AssignmentRequest;

import java.util.List;

public interface AssignmentService {

    List<AssignmentDto> findAllAssignments();

    AssignmentDto findAssignmentById(Long assignmentId);

    void createAssignment(AssignmentRequest assignmentRequest);

    void updateAssignmentById(Long categoryId, AssignmentRequest assignmentRequest);

    void deleteAssignmentById(Long assignmentId);
}
