package it.coachly.api.service.exercise.component.core;

import it.aredegalli.common.exception.NotFoundException;
import it.coachly.api.repository.exercise.core.ExerciseEnvironmentRepository;
import it.coachly.api.repository.exercise.core.ExerciseRepository;
import it.coachly.api.service.exercise.data.component.core.save.ExerciseEnvironmentSaveDto;
import it.coachly.api.service.exercise.mapper.component.core.ExerciseEnvironmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExerciseEnvironmentServiceImpl implements ExerciseEnvironmentService {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseEnvironmentRepository exerciseEnvironmentRepository;

    private final ExerciseEnvironmentMapper exerciseEnvironmentMapper;

    @Override
    public UUID save(ExerciseEnvironmentSaveDto dto) {
        if (!this.exerciseRepository.existsById(dto.getExerciseId())) {
            throw new NotFoundException("Exercise not found");
        }

        return this.exerciseEnvironmentRepository.save(this.exerciseEnvironmentMapper.toEntity(dto)).getId();
    }

}
