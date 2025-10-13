package it.coachly.api.service.exercise.component.safety;

import it.aredegalli.common.exception.NotFoundException;
import it.coachly.api.repository.exercise.core.ExerciseRepository;
import it.coachly.api.repository.exercise.safety.ExerciseSafetyContraindicationRepository;
import it.coachly.api.service.exercise.data.component.safety.ExerciseSafetyContraindicationDto;
import it.coachly.api.service.exercise.data.component.safety.save.ExerciseSafetyContraindicationSaveDto;
import it.coachly.api.service.exercise.finder.component.safety.ExerciseSafetyContraindicationFinder;
import it.coachly.api.service.exercise.mapper.component.core.ExerciseSafetyContraindicationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExerciseSafetyContraindicationServiceImpl implements ExerciseSafetyContraindicationService {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseSafetyContraindicationRepository exerciseSafetyContraindicationRepository;
    private final ExerciseSafetyContraindicationMapper exerciseSafetyContraindicationMapper;
    private final ExerciseSafetyContraindicationFinder exerciseSafetyContraindicationFinder;

    @Override
    public UUID save(ExerciseSafetyContraindicationSaveDto dto) {
        this.exerciseRepository.findById(dto.getExerciseId())
                .orElseThrow(() -> new NotFoundException("Exercise not found"));
        return exerciseSafetyContraindicationRepository.save(exerciseSafetyContraindicationMapper.toEntity(dto)).getId();
    }

    @Override
    public List<UUID> saveAll(List<ExerciseSafetyContraindicationSaveDto> dtos) {
        return dtos.stream().map(this::save).toList();
    }

    @Override
    public void deleteById(UUID id) {
        exerciseSafetyContraindicationRepository.deleteById(id);
    }

    @Override
    public List<ExerciseSafetyContraindicationDto> getExerciseSafetyContraindicationNotes(UUID exerciseId) {
        return exerciseSafetyContraindicationFinder.findExerciseSafetyContraindicationNotes(exerciseId);
    }
}
