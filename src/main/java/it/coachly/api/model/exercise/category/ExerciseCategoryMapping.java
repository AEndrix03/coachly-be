package it.coachly.api.model.exercise.category;

import it.coachly.api.model.exercise.core.Exercise;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "exercise_category_mapping")
public class ExerciseCategoryMapping {
    @EmbeddedId
    private ExerciseCategoryMappingId id;

    @MapsId("exerciseId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @MapsId("categoryId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "category_id", nullable = false)
    private ExerciseCategory category;

    @ColumnDefault("false")
    @Column(name = "is_primary_category")
    private Boolean isPrimaryCategory;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

}