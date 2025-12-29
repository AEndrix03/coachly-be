package it.coachly.api.service.exercise.data.component.core;

import com.querydsl.core.annotations.QueryProjection;
import it.coachly.api.enums.instruction.InstructionTypeEnum;
import it.coachly.api.model.exercise.core.QExerciseInstruction;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Map;
import java.util.UUID;

@Data
@SuperBuilder
@NoArgsConstructor
public class ExerciseInstructionDto {

    private UUID id;
    private InstructionTypeEnum instructionType;
    private Integer stepNumber;
    private Map<String, String> instructionTextI18n;
    private Boolean isCritical;

    @QueryProjection
    public ExerciseInstructionDto(UUID id, InstructionTypeEnum instructionType, Integer stepNumber, Map<String, String> instructionTextI18n, Boolean isCritical) {
        this.id = id;
        this.instructionType = instructionType;
        this.stepNumber = stepNumber;
        this.instructionTextI18n = instructionTextI18n;
        this.isCritical = isCritical;
    }

    public static QExerciseInstructionDto getProjection() {
        QExerciseInstruction qEI = QExerciseInstruction.exerciseInstruction;
        return new QExerciseInstructionDto(
                qEI.id,
                qEI.instructionType,
                qEI.stepNumber,
                qEI.instructionTextI18n,
                qEI.isCritical
        );
    }
}
