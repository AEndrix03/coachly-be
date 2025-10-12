package it.coachly.api.service.exercise.component.category;

import it.coachly.api.service.exercise.data.component.category.save.ExerciseCategorySaveDto;

import java.util.List;
import java.util.UUID;

public interface ExerciseCategoryService {
    UUID save(ExerciseCategorySaveDto dto);

    List<UUID> saveAll(List<ExerciseCategorySaveDto> dtos);

    void deleteById(UUID id);
}

