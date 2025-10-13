package it.coachly.api.service.exercise.component.metric;

import it.aredegalli.common.exception.NotFoundException;
import it.coachly.api.repository.exercise.core.ExerciseRepository;
import it.coachly.api.repository.exercise.metrics.ExerciseMetricRepository;
import it.coachly.api.service.exercise.data.component.metrics.save.ExerciseMetricSaveDto;
import it.coachly.api.service.exercise.mapper.component.core.ExerciseMetricMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExerciseMetricServiceImpl implements ExerciseMetricService {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseMetricRepository exerciseMetricRepository;
    private final ExerciseMetricMapper exerciseMetricMapper;

    @Override
    public UUID save(ExerciseMetricSaveDto dto) {
        this.exerciseRepository.findById(dto.getExerciseId())
                .orElseThrow(() -> new NotFoundException("Exercise not found"));
        return exerciseMetricRepository.save(exerciseMetricMapper.toEntity(dto)).getId();
    }

    @Override
    public void deleteById(UUID id) {
        exerciseMetricRepository.deleteById(id);
    }
}

