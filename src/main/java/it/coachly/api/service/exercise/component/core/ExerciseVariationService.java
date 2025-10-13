package it.coachly.api.service.exercise.component.core;

import it.coachly.api.service.exercise.data.component.core.ExerciseVariantDto;
import it.coachly.api.service.exercise.data.component.core.save.ExerciseVariantSaveDto;

import java.util.List;
import java.util.UUID;

public interface ExerciseVariationService {
    UUID save(ExerciseVariantSaveDto dto);

    void deleteById(UUID id);

    List<ExerciseVariantDto> getExerciseVariants(UUID exerciseId);
}
