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
@Table(name = "workout_template_library")
public class WorkoutTemplateLibrary {
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
    @Column(name = "category", nullable = false, length = 50)
    private String category;

    @Size(max = 50)
    @Column(name = "subcategory", length = 50)
    private String subcategory;

    @Size(max = 255)
    @Column(name = "author_name")
    private String authorName;

    @Column(name = "author_credentials", length = Integer.MAX_VALUE)
    private String authorCredentials;

    @ColumnDefault("0")
    @Column(name = "popularity_score")
    private Integer popularityScore;

    @ColumnDefault("0")
    @Column(name = "times_used")
    private Integer timesUsed;

    @ColumnDefault("false")
    @Column(name = "is_verified")
    private Boolean isVerified;

    @ColumnDefault("false")
    @Column(name = "is_premium")
    private Boolean isPremium;

    @ColumnDefault("0")
    @Column(name = "price_cents")
    private Integer priceCents;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

}