package it.coachly.api.service.exercise.component.core;

import it.coachly.api.service.exercise.data.component.core.ExerciseEnvironmentDto;
import it.coachly.api.service.exercise.data.component.core.save.ExerciseEnvironmentSaveDto;

import java.util.UUID;

public interface ExerciseEnvironmentService {
    UUID save(ExerciseEnvironmentSaveDto dto);

    ExerciseEnvironmentDto getExerciseEnvironment(UUID exerciseId);
}
