package it.coachly.api.model.workout;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "workout_plan_shares")
public class WorkoutPlanShare {
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
    @Column(name = "shared_with_user_id", nullable = false)
    private UUID sharedWithUserId;

    @NotNull
    @Column(name = "shared_by_user_id", nullable = false)
    private UUID sharedByUserId;

    @Size(max = 20)
    @ColumnDefault("'view'")
    @Column(name = "access_level", length = 20)
    private String accessLevel;

    @ColumnDefault("true")
    @Column(name = "is_active")
    private Boolean isActive;

    @ColumnDefault("now()")
    @Column(name = "shared_at")
    private Instant sharedAt;

    @Column(name = "expires_at")
    private Instant expiresAt;

}