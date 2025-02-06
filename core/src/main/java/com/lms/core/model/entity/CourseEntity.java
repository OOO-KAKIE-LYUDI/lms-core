package com.lms.core.model.entity;

import com.lms.auth.model.entity.UserEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course", schema = "lms")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "creator_id")
    private Long creatorId;
    @ManyToOne
    @JoinColumn(name = "creator_id", referencedColumnName = "user_id", updatable = false, insertable = false)
    private UserEntity creator;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "price")
    private Double price;

    @Column(name = "is_published")
    private Boolean isPublished;

    @Column(name = "category_id")
    private Long categoryId;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", updatable = false, insertable = false)
    private CategoryEntity categoryEntity;

    @Column(name = "facility_id")
    private Long facilityId = 1L;
    @ManyToOne
    @JoinColumn(name = "facility_id", referencedColumnName = "facility_id", updatable = false, insertable = false)
    private FacilityEntity facility;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChapterEntity> chapters;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PurchaseEntity> purchases;

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

