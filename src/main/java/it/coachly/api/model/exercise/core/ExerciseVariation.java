package it.coachly.api.model.exercise.core;

import it.coachly.api.enums.exercise.VariationTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "exercise_variations")
public class ExerciseVariation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "base_exercise_id", nullable = false)
    private Exercise baseExercise;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "variant_exercise_id", nullable = false)
    private Exercise variantExercise;

    @Size(max = 50)
    @NotNull
    @Column(name = "variation_type", nullable = false, length = 50)
    private VariationTypeEnum variationType;

    @Column(name = "difficulty_delta")
    private Integer difficultyDelta;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

}