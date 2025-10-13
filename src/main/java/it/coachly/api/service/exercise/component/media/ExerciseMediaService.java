package it.coachly.api.service.exercise.component.media;

import it.coachly.api.service.exercise.data.component.media.ExerciseMediaDto;
import it.coachly.api.service.exercise.data.component.media.save.ExerciseMediaSaveDto;

import java.util.List;
import java.util.UUID;

public interface ExerciseMediaService {
    UUID save(ExerciseMediaSaveDto dto);

    List<UUID> saveAll(List<ExerciseMediaSaveDto> dtos);

    void deleteById(UUID id);

    List<ExerciseMediaDto> getExerciseMedia(UUID exerciseId);
}
