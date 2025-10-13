package it.coachly.api.service.exercise.component.tag;

import it.coachly.api.service.exercise.data.component.tag.save.ExerciseTagSaveDto;
import it.coachly.api.service.tag.data.TagDto;

import java.util.List;
import java.util.UUID;

public interface ExerciseTagService {
    void save(ExerciseTagSaveDto dto);

    List<Void> saveAll(List<ExerciseTagSaveDto> dtos);

    void deleteById(UUID exerciseId, UUID tagId);

    List<TagDto> getExerciseTags(UUID exerciseId);
}
