package it.coachly.api.model.exercise.metrics;

import it.coachly.api.model.exercise.core.Exercise;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "exercise_metrics")
public class ExerciseMetric {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "exercise_id", nullable = false)
    private UUID id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "exercise_id", nullable = false, insertable = false, updatable = false)
    private Exercise exercises;

    @Column(name = "exercise_id", nullable = false)
    private UUID exerciseId;

    @ColumnDefault("0")
    @Column(name = "popularity_score")
    private Integer popularityScore;

    @ColumnDefault("0")
    @Column(name = "usage_count")
    private Integer usageCount;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("now()")
    @Column(name = "updated_at")
    private Instant updatedAt;

}