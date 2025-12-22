package it.coachly.api.model.workout.log;

import it.coachly.api.model.exercise.core.Exercise;
import it.coachly.api.model.workout.WorkoutPlanExercise;
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
@Table(name = "workout_session_exercise_logs")
public class WorkoutSessionExerciseLog {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "workout_session_id", nullable = false)
    private WorkoutSession workoutSession;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "workout_plan_exercise_id")
    private WorkoutPlanExercise workoutPlanExercise;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @NotNull
    @Column(name = "set_number", nullable = false)
    private Integer setNumber;

    @Column(name = "reps")
    private Integer reps;

    @Column(name = "weight_kg", precision = 6, scale = 2)
    private BigDecimal weightKg;

    @Column(name = "distance_meters", precision = 8, scale = 2)
    private BigDecimal distanceMeters;

    @Column(name = "duration_seconds")
    private Integer durationSeconds;

    @Column(name = "rpe")
    private Integer rpe;

    @Column(name = "rir")
    private Integer rir;

    @ColumnDefault("true")
    @Column(name = "completed")
    private Boolean completed;

    @Column(name = "form_rating")
    private Integer formRating;

    @Column(name = "tempo_adherence")
    private Integer tempoAdherence;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @Size(max = 500)
    @Column(name = "video_url", length = 500)
    private String videoUrl;

    @ColumnDefault("now()")
    @Column(name = "logged_at")
    private Instant loggedAt;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

}