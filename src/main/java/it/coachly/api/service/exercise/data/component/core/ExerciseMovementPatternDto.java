package it.coachly.api.service.exercise.data.component.core;

import com.querydsl.core.annotations.QueryProjection;
import it.coachly.api.enums.exercise.MovementPatternEnum;
import it.coachly.api.enums.exercise.MovementPlaneEnum;
import it.coachly.api.enums.exercise.PowerGenerationLevelEnum;
import it.coachly.api.model.exercise.core.QExerciseMovementPattern;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@SuperBuilder
public class ExerciseMovementPatternDto {
    private final UUID id;
    private final MovementPlaneEnum movementPlane;
    private final MovementPatternEnum movementPattern;
    private final PowerGenerationLevelEnum powerGenerationLevel;

    @QueryProjection
    public ExerciseMovementPatternDto(UUID id, MovementPlaneEnum movementPlane, MovementPatternEnum movementPattern, PowerGenerationLevelEnum powerGenerationLevel) {
        this.id = id;
        this.movementPlane = movementPlane;
        this.movementPattern = movementPattern;
        this.powerGenerationLevel = powerGenerationLevel;
    }

    public static QExerciseMovementPatternDto getProjection() {
        QExerciseMovementPattern qEMP = QExerciseMovementPattern.exerciseMovementPattern;
        return new QExerciseMovementPatternDto(
                qEMP.id,
                qEMP.movementPlane,
                qEMP.movementPattern,
                qEMP.powerGenerationLevel
        );
    }
}
