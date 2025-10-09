package it.coachly.api.model.exercise.core;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "exercise_movement_patterns")
public class ExerciseMovementPattern {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "exercise_id", nullable = false)
    private UUID id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercises;

    @Size(max = 30)
    @Column(name = "movement_plane", length = 30)
    private String movementPlane;

    @Size(max = 100)
    @Column(name = "movement_pattern", length = 100)
    private String movementPattern;

    @Size(max = 20)
    @Column(name = "power_generation_level", length = 20)
    private String powerGenerationLevel;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

}