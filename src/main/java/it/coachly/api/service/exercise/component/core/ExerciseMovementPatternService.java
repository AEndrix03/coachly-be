package it.coachly.api.service.exercise.component.core;

import it.coachly.api.service.exercise.data.component.core.ExerciseMovementPatternDto;
import it.coachly.api.service.exercise.data.component.core.save.ExerciseMovementPatternSaveDto;

import java.util.UUID;

public interface ExerciseMovementPatternService {
    UUID save(ExerciseMovementPatternSaveDto dto);

    void deleteById(UUID id);

    ExerciseMovementPatternDto getExerciseMovementPattern(UUID exerciseId);
}
