package com.lms.core.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "text_assignment_step", schema = "lms")
@DiscriminatorValue(value = "text")
public class TextAssignmentStep extends AssignmentStep{
    @Column(name = "correct_answer")
    private String correctAnswer;
}
