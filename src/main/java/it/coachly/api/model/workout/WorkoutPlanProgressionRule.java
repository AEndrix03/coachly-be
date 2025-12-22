package it.coachly.api.model.workout;

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
@Table(name = "workout_plan_progression_rules")
public class WorkoutPlanProgressionRule {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "workout_plan_id", nullable = false)
    private WorkoutPlan workoutPlan;

    @Size(max = 50)
    @NotNull
    @Column(name = "rule_type", nullable = false, length = 50)
    private String ruleType;

    @Size(max = 30)
    @NotNull
    @Column(name = "progression_frequency", nullable = false, length = 30)
    private String progressionFrequency;

    @Column(name = "applies_to_exercises")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> appliesToExercises;

    @Column(name = "weight_increase_kg", precision = 4, scale = 2)
    private BigDecimal weightIncreaseKg;

    @Column(name = "weight_increase_percentage", precision = 4, scale = 2)
    private BigDecimal weightIncreasePercentage;

    @Column(name = "reps_increase")
    private Integer repsIncrease;

    @Column(name = "sets_increase")
    private Integer setsIncrease;

    @Column(name = "trigger_condition")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> triggerCondition;

    @Column(name = "deload_every_n_weeks")
    private Integer deloadEveryNWeeks;

    @Column(name = "deload_percentage", precision = 4, scale = 2)
    private BigDecimal deloadPercentage;

    @ColumnDefault("true")
    @Column(name = "is_active")
    private Boolean isActive;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

}