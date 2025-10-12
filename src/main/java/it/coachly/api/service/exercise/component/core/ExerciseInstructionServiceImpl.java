package it.coachly.api.service.exercise.component.core;

import it.aredegalli.common.exception.NotFoundException;
import it.coachly.api.repository.exercise.core.ExerciseInstructionRepository;
import it.coachly.api.repository.exercise.core.ExerciseRepository;
import it.coachly.api.service.exercise.data.component.core.save.ExerciseInstructionSaveDto;
import it.coachly.api.service.exercise.mapper.component.core.ExerciseInstructionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExerciseInstructionServiceImpl implements ExerciseInstructionService {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseInstructionRepository exerciseInstructionRepository;

    private final ExerciseInstructionMapper exerciseInstructionMapper;

    @Override
    public UUID save(ExerciseInstructionSaveDto dto) {
        var exercise = exerciseRepository.findById(dto.getExerciseId())
                .orElseThrow(() -> new NotFoundException("Exercise not found"));

        return exerciseInstructionRepository.save(exerciseInstructionMapper.toEntity(dto)).getId();
    }

    @Override
    public List<UUID> saveAll(List<ExerciseInstructionSaveDto> dtos) {
        return dtos.stream().map(this::save).toList();
    }

    @Override
    public void deleteById(UUID id) {
        exerciseInstructionRepository.deleteById(id);
    }

}
