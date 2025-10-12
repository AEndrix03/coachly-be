package it.coachly.api.service.exercise.mapper.component.core;

import it.coachly.api.model.exercise.core.ExerciseMovementPattern;
import it.coachly.api.service.exercise.data.component.core.save.ExerciseMovementPatternSaveDto;
import it.coachly.api.util.mapper.IEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class ExerciseMovementPatternMapper implements IEntityMapper<ExerciseMovementPatternSaveDto, ExerciseMovementPattern> {
    @Override
    public ExerciseMovementPattern toEntity(ExerciseMovementPatternSaveDto dto) {
        return ExerciseMovementPattern.builder()
                .id(dto.getId())
                .exerciseId(dto.getExerciseId())
                .movementPlane(dto.getMovementPlane())
                .movementPattern(dto.getMovementPattern())
                .powerGenerationLevel(dto.getPowerGenerationLevel())
                .build();
    }
}

