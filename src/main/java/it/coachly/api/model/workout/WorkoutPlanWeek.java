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
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "workout_plan_weeks")
public class WorkoutPlanWeek {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "workout_plan_id", nullable = false)
    private WorkoutPlan workoutPlan;

    @NotNull
    @Column(name = "week_number", nullable = false)
    private Integer weekNumber;

    @Column(name = "title_i18n")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> titleI18n;

    @Column(name = "notes_i18n")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> notesI18n;

    @ColumnDefault("false")
    @Column(name = "deload_week")
    private Boolean deloadWeek;

    @ColumnDefault("100")
    @Column(name = "intensity_percentage")
    private Integer intensityPercentage;

    @ColumnDefault("100")
    @Column(name = "volume_percentage")
    private Integer volumePercentage;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

}