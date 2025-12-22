package it.coachly.api.model.workout.log;

import it.coachly.api.model.workout.session.WorkoutSession;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "workout_session_cardio_logs")
public class WorkoutSessionCardioLog {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "workout_session_id", nullable = false)
    private WorkoutSession workoutSession;

    @Size(max = 50)
    @NotNull
    @Column(name = "cardio_type", nullable = false, length = 50)
    private String cardioType;

    @Column(name = "duration_minutes")
    private Integer durationMinutes;

    @Column(name = "distance_meters", precision = 10, scale = 2)
    private BigDecimal distanceMeters;

    @Column(name = "average_heart_rate")
    private Integer averageHeartRate;

    @Column(name = "max_heart_rate")
    private Integer maxHeartRate;

    @Column(name = "calories_burned")
    private Integer caloriesBurned;

    @Size(max = 20)
    @Column(name = "intensity_zone", length = 20)
    private String intensityZone;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

}