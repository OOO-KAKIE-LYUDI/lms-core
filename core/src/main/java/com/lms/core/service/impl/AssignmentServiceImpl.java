package com.lms.core.service.impl;

import com.lms.core.exception.LmsNotFoundException;
import com.lms.core.model.dto.assignment.AssignmentDto;
import com.lms.core.model.dto.assignment.AssignmentRequest;
import com.lms.core.model.entity.AssignmentEntity;
import com.lms.core.model.mapper.AssignmentMapper;
import com.lms.core.repository.AssignmentRepository;
import com.lms.core.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final AssignmentMapper assignmentMapper;

    @Override
    public List<AssignmentDto> findAllAssignments() {
        List<AssignmentEntity> assignments = assignmentRepository.findAll();

        if (CollectionUtils.isEmpty(assignments)) {
            throw new LmsNotFoundException("Не найдено ни одного задания");
        }

        return assignments.stream().map(assignmentMapper::toDto).toList();
    }

    @Override
    public AssignmentDto findAssignmentById(Long assignmentId) {
        var assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new LmsNotFoundException("Не найдено ни одного задания с <assignmentId>=%d".formatted(assignmentId)));

        return assignmentMapper.toDto(assignment);
    }

    @Override
    public void createAssignment(AssignmentRequest assignmentRequest) {
        var assignmentEntity = assignmentMapper.toEntity(assignmentRequest);
        assignmentRepository.save(assignmentEntity);
    }

    @Override
    @Transactional
    public void updateAssignmentById(Long assignmentId, AssignmentRequest assignmentRequest) {
        var assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new LmsNotFoundException("Не найдено ни одного задания с <assignmentId>=%d".formatted(assignmentId)));
    }

    @Override
    public void deleteAssignmentById(Long assignmentId) {
        assignmentRepository.deleteById(assignmentId);
    }
}
