package com.lms.algo.model.entity;

import com.lms.algo.model.enums.SubmissionStatusEnum;
import com.lms.auth.model.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "submission", schema = "lms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubmissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "submission_id")
    private Long submissionId;

    @ManyToOne
    @JoinColumn(name = "problem_id", insertable = false, updatable = false)
    private ProblemEntity problem;

    @Column(name = "problem_id", nullable = false)
    private Long problemId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String code;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private LanguageEntity language;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity user;

    @Column(name = "user_id")
    private Long userId;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false, length = 50)
    private SubmissionStatusEnum status;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;
}
