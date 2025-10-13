package it.coachly.api.service.exercise.component.safety;

import it.aredegalli.common.exception.NotFoundException;
import it.coachly.api.repository.exercise.core.ExerciseRepository;
import it.coachly.api.repository.exercise.safety.ExerciseSafetyRepository;
import it.coachly.api.service.exercise.data.component.safety.save.ExerciseSafetySaveDto;
import it.coachly.api.service.exercise.mapper.component.core.ExerciseSafetyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExerciseSafetyServiceImpl implements ExerciseSafetyService {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseSafetyRepository exerciseSafetyRepository;
    private final ExerciseSafetyMapper exerciseSafetyMapper;

    @Override
    public UUID save(ExerciseSafetySaveDto dto) {
        this.exerciseRepository.findById(dto.getExerciseId())
                .orElseThrow(() -> new NotFoundException("Exercise not found"));
        return exerciseSafetyRepository.save(exerciseSafetyMapper.toEntity(dto)).getId();
    }

    @Override
    public void deleteById(UUID id) {
        exerciseSafetyRepository.deleteById(id);
    }
}

