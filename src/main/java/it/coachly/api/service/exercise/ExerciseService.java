package it.coachly.api.service.exercise;

import it.coachly.api.service.exercise.data.ExerciseDto;
import it.coachly.api.service.exercise.data.save.ExerciseSaveDto;
import it.coachly.api.service.exercise.data.detail.ExerciseDetailDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ExerciseService {
    Page<ExerciseDto> getPaginated(Pageable pageable);

    ExerciseDetailDto getDetailById(UUID id);

    UUID save(ExerciseSaveDto dto);

    void deleteById(UUID id);
}
