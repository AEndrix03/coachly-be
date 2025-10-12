package it.coachly.api.service.exercise.data.component.muscle.save;

import it.coachly.api.enums.muscle.InvolvementLevelEnum;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@SuperBuilder
public class ExerciseMuscleSaveDto {
    private final UUID exerciseId;
    private final UUID muscleId;
    private InvolvementLevelEnum involvementLevel;
    private UUID primaryContractionTypeId;
    private Integer activationPercentage;

    public ExerciseMuscleSaveDto(UUID exerciseId, UUID muscleId, InvolvementLevelEnum involvementLevel, UUID primaryContractionTypeId, Integer activationPercentage) {
        this.exerciseId = exerciseId;
        this.muscleId = muscleId;
        this.involvementLevel = involvementLevel;
        this.primaryContractionTypeId = primaryContractionTypeId;
        this.activationPercentage = activationPercentage;
    }
}

