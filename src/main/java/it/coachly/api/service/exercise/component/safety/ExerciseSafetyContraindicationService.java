package it.coachly.api.service.exercise.component.safety;

import it.coachly.api.service.exercise.data.component.safety.save.ExerciseSafetyContraindicationSaveDto;

import java.util.List;
import java.util.UUID;

public interface ExerciseSafetyContraindicationService {
    UUID save(ExerciseSafetyContraindicationSaveDto dto);

    List<UUID> saveAll(List<ExerciseSafetyContraindicationSaveDto> dtos);

    void deleteById(UUID id);
}

