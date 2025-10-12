package it.coachly.api.service.exercise.data.component.core.save;

import it.coachly.api.enums.exercise.MovementPatternEnum;
import it.coachly.api.enums.exercise.MovementPlaneEnum;
import it.coachly.api.enums.exercise.PowerGenerationLevelEnum;
import it.coachly.api.service.exercise.data.component.core.ExerciseMovementPatternDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@SuperBuilder
public class ExerciseMovementPatternSaveDto extends ExerciseMovementPatternDto {
    private final UUID exerciseId;

    public ExerciseMovementPatternSaveDto(UUID id, MovementPlaneEnum movementPlane, MovementPatternEnum movementPattern, PowerGenerationLevelEnum powerGenerationLevel, UUID exerciseId) {
        super(id, movementPlane, movementPattern, powerGenerationLevel);
        this.exerciseId = exerciseId;
    }
}

