package com.lms.core.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "survey_assignment_step", schema = "lms")
@DiscriminatorValue(value = "survey")
public class SurveyAssignmentStep extends AssignmentStep{

    @Column(name = "survey")
    @Enumerated(value = EnumType.STRING)
    private SurveyType type;
}
