package it.coachly.api.model.workout.exercise;

import it.coachly.api.model.workout.WorkoutPlan;
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

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "workout_exercise_groups")
public class WorkoutExerciseGroup {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "workout_plan_id", nullable = false)
    private WorkoutPlan workoutPlan;

    @Size(max = 30)
    @NotNull
    @Column(name = "group_type", nullable = false, length = 30)
    private String groupType;

    @NotNull
    @Column(name = "group_order", nullable = false)
    private Integer groupOrder;

    @Column(name = "title_i18n")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> titleI18n;

    @Column(name = "notes_i18n")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> notesI18n;

    @ColumnDefault("0")
    @Column(name = "rest_between_exercises_seconds")
    private Integer restBetweenExercisesSeconds;

    @ColumnDefault("90")
    @Column(name = "rest_after_group_seconds")
    private Integer restAfterGroupSeconds;

    @ColumnDefault("1")
    @Column(name = "rounds")
    private Integer rounds;

    @ColumnDefault("false")
    @Column(name = "is_antagonist_pair")
    private Boolean isAntagonistPair;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

}