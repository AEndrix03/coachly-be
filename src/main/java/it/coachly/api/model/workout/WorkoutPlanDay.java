package it.coachly.api.model.workout;

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
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "workout_plan_days")
public class WorkoutPlanDay {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "workout_plan_week_id", nullable = false)
    private WorkoutPlanWeek workoutPlanWeek;

    @NotNull
    @Column(name = "day_number", nullable = false)
    private Integer dayNumber;

    @NotNull
    @Column(name = "title_i18n", nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> titleI18n;

    @Column(name = "description_i18n")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> descriptionI18n;

    @Column(name = "notes_i18n")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> notesI18n;

    @ColumnDefault("false")
    @Column(name = "is_rest_day")
    private Boolean isRestDay;

    @Column(name = "estimated_duration_minutes")
    private Integer estimatedDurationMinutes;

    @ColumnDefault("0")
    @Column(name = "display_order")
    private Integer displayOrder;

    @Column(name = "focus_muscle_groups")
    private List<String> focusMuscleGroups;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

}