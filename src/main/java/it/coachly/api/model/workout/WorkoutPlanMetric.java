package it.coachly.api.model.workout;

import jakarta.persistence.*;
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
@Table(name = "workout_plan_metrics")
public class WorkoutPlanMetric {
    @Id
    @Column(name = "workout_plan_id", nullable = false)
    private UUID id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "workout_plan_id", nullable = false)
    private WorkoutPlan workoutPlans;

    @ColumnDefault("0")
    @Column(name = "total_uses")
    private Integer totalUses;

    @ColumnDefault("0")
    @Column(name = "active_users")
    private Integer activeUsers;

    @ColumnDefault("0")
    @Column(name = "completed_sessions")
    private Integer completedSessions;

    @Column(name = "average_completion_rate", precision = 5, scale = 2)
    private BigDecimal averageCompletionRate;

    @Column(name = "average_rating", precision = 3, scale = 2)
    private BigDecimal averageRating;

    @ColumnDefault("0")
    @Column(name = "total_ratings")
    private Integer totalRatings;

    @Column(name = "last_used_at")
    private Instant lastUsedAt;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("now()")
    @Column(name = "updated_at")
    private Instant updatedAt;

}