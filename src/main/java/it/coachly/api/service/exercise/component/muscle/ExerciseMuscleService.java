package it.coachly.api.service.exercise.component.muscle;

import it.coachly.api.service.exercise.data.component.muscle.save.ExerciseMuscleSaveDto;

import java.util.List;
import java.util.UUID;

public interface ExerciseMuscleService {
    UUID save(ExerciseMuscleSaveDto dto);

    List<UUID> saveAll(List<ExerciseMuscleSaveDto> dtos);

    void deleteById(UUID id);
}

