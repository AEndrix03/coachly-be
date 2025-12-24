package it.coachly.api.service.workout.data;


import com.querydsl.core.annotations.QueryProjection;
import com.querydsl.core.types.dsl.Expressions;
import it.coachly.api.model.workout.QWorkoutPlan;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Data
@Builder
public class WorkoutDto {

    private UUID id;
    private Map<String, Object> titleI18n;
    private Map<String, Object> descriptionI18n;

    private UUID coachId;
    private String coachName;

    private BigDecimal progress;
    private Integer exercises;
    private Integer durationMinutes;

    private String goal;

    private LocalDateTime lastUsed;

    private Boolean active;

    @QueryProjection
    public WorkoutDto(UUID id, Map<String, Object> titleI18n, Map<String, Object> descriptionI18n, UUID coachId, String coachName, BigDecimal progress, Integer exercises, Integer durationMinutes, String goal, LocalDateTime lastUsed, Boolean active) {
        this.id = id;
        this.titleI18n = titleI18n;
        this.descriptionI18n = descriptionI18n;
        this.coachId = coachId;
        this.coachName = coachName;
        this.progress = progress;
        this.exercises = exercises;
        this.durationMinutes = durationMinutes;
        this.goal = goal;
        this.lastUsed = lastUsed;
        this.active = active;
    }

    public static QWorkoutDto getProjection() {
        QWorkoutPlan qWP = QWorkoutPlan.workoutPlan;
        return new QWorkoutDto(
                qWP.id,
                qWP.titleI18n,
                qWP.descriptionI18n,
                qWP.id, //TODO
                Expressions.asString("Leonardo"),
                Expressions.asNumber(BigDecimal.valueOf(55.5)),
                Expressions.asNumber(7),
                Expressions.asNumber(45),
                qWP.targetGoal,
                Expressions.asDate(LocalDateTime.now()),
                Expressions.asBoolean(true)
        );
    }
}
