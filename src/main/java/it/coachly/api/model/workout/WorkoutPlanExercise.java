package it.coachly.api.model.workout;

import it.coachly.api.model.exercise.core.Exercise;
import it.coachly.api.model.workout.exercise.WorkoutExerciseGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "workout_plan_exercises")
public class WorkoutPlanExercise {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "workout_exercise_group_id", nullable = false)
    private WorkoutExerciseGroup workoutExerciseGroup;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @NotNull
    @Column(name = "exercise_order", nullable = false)
    private Integer exerciseOrder;

    @Column(name = "sets")
    private Integer sets;

    @Column(name = "reps_min")
    private Integer repsMin;

    @Column(name = "reps_max")
    private Integer repsMax;

    @Size(max = 30)
    @ColumnDefault("'fixed'")
    @Column(name = "reps_type", length = 30)
    private String repsType;

    @Column(name = "weight_kg", precision = 6, scale = 2)
    private BigDecimal weightKg;

    @Column(name = "weight_percentage")
    private Integer weightPercentage;

    @Column(name = "rpe_target")
    private Integer rpeTarget;

    @Column(name = "rir_target")
    private Integer rirTarget;

    @Column(name = "tempo_eccentric")
    private Integer tempoEccentric;

    @Column(name = "tempo_bottom_pause")
    private Integer tempoBottomPause;

    @Column(name = "tempo_concentric")
    private Integer tempoConcentric;

    @Column(name = "tempo_top_pause")
    private Integer tempoTopPause;

    @ColumnDefault("90")
    @Column(name = "rest_seconds")
    private Integer restSeconds;

    @Column(name = "duration_seconds")
    private Integer durationSeconds;

    @Column(name = "notes_i18n")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> notesI18n;

    @Column(name = "coaching_cues_i18n")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> coachingCuesI18n;

    @ColumnDefault("false")
    @Column(name = "is_warmup")
    private Boolean isWarmup;

    @ColumnDefault("false")
    @Column(name = "is_cooldown")
    private Boolean isCooldown;

    @ColumnDefault("false")
    @Column(name = "is_optional")
    private Boolean isOptional;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("now()")
    @Column(name = "updated_at")
    private Instant updatedAt;

}