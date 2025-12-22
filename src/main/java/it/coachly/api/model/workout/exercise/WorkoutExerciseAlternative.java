package it.coachly.api.model.workout.exercise;

import it.coachly.api.model.exercise.core.Exercise;
import it.coachly.api.model.workout.WorkoutPlanExercise;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "workout_exercise_alternatives")
public class WorkoutExerciseAlternative {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "workout_plan_exercise_id", nullable = false)
    private WorkoutPlanExercise workoutPlanExercise;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "alternative_exercise_id", nullable = false)
    private Exercise alternativeExercise;

    @Column(name = "reason_i18n")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> reasonI18n;

    @ColumnDefault("1")
    @Column(name = "priority")
    private Integer priority;

    @ColumnDefault("true")
    @Column(name = "auto_adjust_parameters")
    private Boolean autoAdjustParameters;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

}