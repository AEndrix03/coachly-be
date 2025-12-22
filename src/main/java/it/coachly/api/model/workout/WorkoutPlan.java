package it.coachly.api.model.workout;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "workout_plans")
public class WorkoutPlan {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

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

    @NotNull
    @Column(name = "created_by_user_id", nullable = false)
    private UUID createdByUserId;

    @Size(max = 30)
    @NotNull
    @Column(name = "plan_type", nullable = false, length = 30)
    private String planType;

    @Size(max = 20)
    @Column(name = "difficulty_level", length = 20)
    private String difficultyLevel;

    @Column(name = "duration_weeks")
    private Integer durationWeeks;

    @Column(name = "workouts_per_week")
    private Integer workoutsPerWeek;

    @Size(max = 50)
    @Column(name = "target_goal", length = 50)
    private String targetGoal;

    @ColumnDefault("false")
    @Column(name = "is_public")
    private Boolean isPublic;

    @ColumnDefault("false")
    @Column(name = "is_featured")
    private Boolean isFeatured;

    @ColumnDefault("true")
    @Column(name = "is_active")
    private Boolean isActive;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("now()")
    @Column(name = "updated_at")
    private Instant updatedAt;

}