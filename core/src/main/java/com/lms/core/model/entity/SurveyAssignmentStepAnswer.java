package com.lms.core.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "survey_assignment_step_answer", schema = "lms")
public class SurveyAssignmentStepAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_assignment_step_answer_id")
    private Long surveyAssignmentStepAnswerId;

    @Column(name = "assignment_step_answer_id")
    private Long assignmentStepAnswerId;
    @ManyToOne
    @JoinColumn(name = "assignment_step_answer_id", referencedColumnName = "assignment_step_answer_id", updatable = false, insertable = false)
    private AssignmentStep assignmentStep;

    @Column(name = "name")
    private String name;

    @Column(name = "is_correct")
    private Boolean isCorrect;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
