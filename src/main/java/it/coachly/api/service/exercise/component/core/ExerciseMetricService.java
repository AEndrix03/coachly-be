package it.coachly.api.service.exercise.component.core;

import it.coachly.api.service.exercise.data.component.metrics.save.ExerciseMetricSaveDto;

import java.util.UUID;

public interface ExerciseMetricService {
    UUID save(ExerciseMetricSaveDto dto);

    void deleteById(UUID id);
}

