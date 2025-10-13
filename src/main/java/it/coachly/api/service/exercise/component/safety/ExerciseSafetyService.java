package it.coachly.api.service.exercise.component.safety;

import it.coachly.api.service.exercise.data.component.safety.save.ExerciseSafetySaveDto;

import java.util.UUID;

public interface ExerciseSafetyService {
    UUID save(ExerciseSafetySaveDto dto);

    void deleteById(UUID id);
}

