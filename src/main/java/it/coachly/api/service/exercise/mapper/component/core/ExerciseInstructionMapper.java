package it.coachly.api.service.exercise.mapper.component.core;

import it.coachly.api.model.exercise.core.ExerciseInstruction;
import it.coachly.api.service.exercise.data.component.core.save.ExerciseInstructionSaveDto;
import it.coachly.api.util.mapper.IEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class ExerciseInstructionMapper implements IEntityMapper<ExerciseInstructionSaveDto, ExerciseInstruction> {

    @Override
    public ExerciseInstruction toEntity(ExerciseInstructionSaveDto dto) {
        return ExerciseInstruction.builder()
                .id(dto.getId())
                .exerciseId(dto.getExerciseId())
                .instructionType(dto.getInstructionType())
                .stepNumber(dto.getStepNumber())
                .instructionTextI18n(dto.getInstructionTextI18n())
                .isCritical(dto.getIsCritical())
                .build();
    }
}
