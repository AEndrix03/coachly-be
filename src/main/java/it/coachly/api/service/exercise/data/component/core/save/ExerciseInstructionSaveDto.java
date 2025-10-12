package it.coachly.api.service.exercise.data.component.core.save;

import it.coachly.api.enums.instruction.InstructionTypeEnum;
import it.coachly.api.service.exercise.data.component.core.ExerciseInstructionDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Map;
import java.util.UUID;

@Data
@SuperBuilder
public class ExerciseInstructionSaveDto extends ExerciseInstructionDto {

    private final UUID exerciseId;

    public ExerciseInstructionSaveDto(UUID id, InstructionTypeEnum instructionType, Integer stepNumber, Map<String, String> instructionTextI18n, Boolean isCritical, UUID exerciseId) {
        super(id, instructionType, stepNumber, instructionTextI18n, isCritical);
        this.exerciseId = exerciseId;
    }
}
