package it.coachly.api.service.exercise.component.muscle;

import it.aredegalli.common.exception.NotFoundException;
import it.coachly.api.repository.exercise.core.ExerciseRepository;
import it.coachly.api.repository.muscle.exercise.ExerciseMuscleRepository;
import it.coachly.api.service.exercise.data.component.muscle.ExerciseMuscleDto;
import it.coachly.api.service.exercise.data.component.muscle.save.ExerciseMuscleSaveDto;
import it.coachly.api.service.exercise.finder.component.muscle.ExerciseMuscleFinder;
import it.coachly.api.service.exercise.mapper.component.muscle.ExerciseMuscleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExerciseMuscleServiceImpl implements ExerciseMuscleService {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseMuscleRepository exerciseMuscleRepository;
    private final ExerciseMuscleMapper exerciseMuscleMapper;
    private final ExerciseMuscleFinder exerciseMuscleFinder;

    @Override
    public UUID save(ExerciseMuscleSaveDto dto) {
        this.exerciseRepository.findById(dto.getExerciseId())
                .orElseThrow(() -> new NotFoundException("Exercise not found"));
        return exerciseMuscleRepository.save(exerciseMuscleMapper.toEntity(dto)).getId();
    }

    @Override
    public List<UUID> saveAll(List<ExerciseMuscleSaveDto> dtos) {
        return dtos.stream().map(this::save).toList();
    }

    @Override
    public void deleteById(UUID id) {
        exerciseMuscleRepository.deleteById(id);
    }

    @Override
    public List<ExerciseMuscleDto> getExerciseMuscles(UUID exerciseId) {
        return exerciseMuscleFinder.findExerciseMuscles(exerciseId);
    }
}
