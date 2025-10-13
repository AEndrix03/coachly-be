package it.coachly.api.service.exercise.component.core;

import it.coachly.api.service.exercise.data.component.core.ExerciseInstructionDto;
import it.coachly.api.service.exercise.data.component.core.save.ExerciseInstructionSaveDto;

import java.util.List;
import java.util.UUID;

public interface ExerciseInstructionService {
    UUID save(ExerciseInstructionSaveDto dto);

    List<UUID> saveAll(List<ExerciseInstructionSaveDto> dtos);

    void deleteById(UUID id);

    List<ExerciseInstructionDto> getExerciseInstructions(UUID exerciseId);
}
