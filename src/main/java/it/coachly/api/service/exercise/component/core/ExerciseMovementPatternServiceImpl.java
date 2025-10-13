package it.coachly.api.service.exercise.component.core;

import it.aredegalli.common.exception.NotFoundException;
import it.coachly.api.repository.exercise.core.ExerciseMovementPatternRepository;
import it.coachly.api.repository.exercise.core.ExerciseRepository;
import it.coachly.api.service.exercise.data.component.core.ExerciseMovementPatternDto;
import it.coachly.api.service.exercise.data.component.core.save.ExerciseMovementPatternSaveDto;
import it.coachly.api.service.exercise.finder.component.core.ExerciseMovementPatternFinder;
import it.coachly.api.service.exercise.mapper.component.core.ExerciseMovementPatternMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExerciseMovementPatternServiceImpl implements ExerciseMovementPatternService {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseMovementPatternRepository exerciseMovementPatternRepository;
    private final ExerciseMovementPatternMapper exerciseMovementPatternMapper;
    private final ExerciseMovementPatternFinder exerciseMovementPatternFinder;

    @Override
    public UUID save(ExerciseMovementPatternSaveDto dto) {
        this.exerciseRepository.findById(dto.getExerciseId())
                .orElseThrow(() -> new NotFoundException("Exercise not found"));
        return exerciseMovementPatternRepository.save(exerciseMovementPatternMapper.toEntity(dto)).getId();
    }

    @Override
    public void deleteById(UUID id) {
        exerciseMovementPatternRepository.deleteById(id);
    }

    @Override
    public ExerciseMovementPatternDto getExerciseMovementPattern(UUID exerciseId) {
        return exerciseMovementPatternFinder.findExerciseMovementPattern(exerciseId);
    }
}
