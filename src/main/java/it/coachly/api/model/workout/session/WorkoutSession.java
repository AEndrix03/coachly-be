package it.coachly.api.model.workout.session;

import it.coachly.api.model.workout.WorkoutPlan;
import it.coachly.api.model.workout.WorkoutPlanDay;
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
import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "workout_sessions")
public class WorkoutSession {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "workout_plan_id")
    private WorkoutPlan workoutPlan;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "workout_plan_day_id")
    private WorkoutPlanDay workoutPlanDay;

    @NotNull
    @Column(name = "session_date", nullable = false)
    private LocalDate sessionDate;

    @Column(name = "started_at")
    private Instant startedAt;

    @Column(name = "completed_at")
    private Instant completedAt;

    @Size(max = 30)
    @ColumnDefault("'planned'")
    @Column(name = "status", length = 30)
    private String status;

    @Column(name = "notes_i18n")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> notesI18n;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "perceived_difficulty")
    private Integer perceivedDifficulty;

    @Column(name = "total_volume_kg", precision = 12, scale = 2)
    private BigDecimal totalVolumeKg;

    @Column(name = "total_reps")
    private Integer totalReps;

    @Column(name = "total_sets")
    private Integer totalSets;

    @Column(name = "duration_minutes")
    private Integer durationMinutes;

    @Size(max = 50)
    @Column(name = "device_type", length = 50)
    private String deviceType;

    @Size(max = 30)
    @Column(name = "location_type", length = 30)
    private String locationType;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("now()")
    @Column(name = "updated_at")
    private Instant updatedAt;

}