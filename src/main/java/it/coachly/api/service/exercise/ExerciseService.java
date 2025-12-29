package it.coachly.api.service.exercise;

import it.coachly.api.service.exercise.data.ExerciseDto;
import it.coachly.api.service.exercise.data.ExerciseFilterDto;
import it.coachly.api.service.exercise.data.detail.ExerciseDetailDto;
import it.coachly.api.service.exercise.data.save.ExerciseSaveDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ExerciseService {
    Page<ExerciseDto> getPaginated(Pageable pageable);

    ExerciseDetailDto getDetailById(UUID id);

    List<ExerciseDetailDto> getDetailByFilter(ExerciseFilterDto filter);

    UUID save(ExerciseSaveDto dto);

    void deleteById(UUID id);
}
