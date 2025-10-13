package it.coachly.api.service.exercise.component.safety;

import it.coachly.api.service.exercise.data.component.safety.ExerciseSafetyDto;
import it.coachly.api.service.exercise.data.component.safety.save.ExerciseSafetySaveDto;

import java.util.List;
import java.util.UUID;

public interface ExerciseSafetyService {
    UUID save(ExerciseSafetySaveDto dto);

    void deleteById(UUID id);

    List<ExerciseSafetyDto> getExerciseSafetyNotes(UUID exerciseId);
}
