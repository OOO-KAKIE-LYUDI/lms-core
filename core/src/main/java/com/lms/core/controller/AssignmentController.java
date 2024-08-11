package com.lms.core.controller;

import com.lms.core.model.dto.assignment.AssignmentDto;
import com.lms.core.model.dto.assignment.AssignmentRequest;
import com.lms.core.service.AssignmentService;
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
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Validated
public class AssignmentController {

    private final AssignmentService assignmentService;

    @GetMapping
    List<AssignmentDto> findAll() {
        return assignmentService.findAllAssignments();
    }

    @GetMapping("/{id}")
    AssignmentDto findById(@PathVariable @NotNull Long id) {
        return assignmentService.findAssignmentById(id);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable @NotNull Long id) {
        assignmentService.deleteAssignmentById(id);
    }

    @PostMapping
    void postCategory(@RequestBody
                      @NotNull
                      @Valid
                      AssignmentRequest assignmentRequest) {
        assignmentService.createAssignment(assignmentRequest);
    }

    @PatchMapping("/{id}")
    void patchCategory(@PathVariable
                       @NotNull
                       Long id,
                       @RequestBody
                       @NotNull
                       @Valid
                       AssignmentRequest assignmentRequest) {
        assignmentService.updateAssignmentById(id, assignmentRequest);
    }
}
