package com.lms.algo.model.entity;

import com.lms.algo.model.enums.SubmittedTestCaseResultEnum;
import com.lms.algo.model.enums.SubmittedTestCaseStatusEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "submitted_test_case", schema = "lms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubmittedTestCaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "submitted_test_case_id")
    private Long submittedTestCaseId;

    @ManyToOne
    @JoinColumn(name = "submission_id", referencedColumnName = "submission_id", insertable = false, updatable = false)
    private SubmissionEntity submission;

    @Column(name = "submission_id", nullable = false)
    private Long submissionId;

    @ManyToOne
    @JoinColumn(name = "test_case_id", referencedColumnName = "test_case_id", insertable = false, updatable = false)
    private TestCaseEntity testCase;

    @Column(name = "test_case_id", nullable = false)
    private Long testCaseId;

    @Column(name = "judge_integrator_id")
    private Long judgeIntegratorId;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private SubmittedTestCaseStatusEnum status;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "result")
    private SubmittedTestCaseResultEnum result;

    @Column(name = "result_message")
    private String resultMessage;
}
