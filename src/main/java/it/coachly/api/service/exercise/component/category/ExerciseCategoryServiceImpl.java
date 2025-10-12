package it.coachly.api.service.exercise.component.category;

import it.aredegalli.common.exception.NotFoundException;
import it.coachly.api.repository.exercise.category.ExerciseCategoryRepository;
import it.coachly.api.repository.exercise.core.ExerciseRepository;
import it.coachly.api.service.exercise.data.component.category.save.ExerciseCategorySaveDto;
import it.coachly.api.service.exercise.mapper.component.category.ExerciseCategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExerciseCategoryServiceImpl implements ExerciseCategoryService {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseCategoryRepository exerciseCategoryRepository;
    private final ExerciseCategoryMapper exerciseCategoryMapper;

    @Override
    public UUID save(ExerciseCategorySaveDto dto) {
        this.exerciseRepository.findById(dto.getExerciseId())
                .orElseThrow(() -> new NotFoundException("Exercise not found"));
        return exerciseCategoryRepository.save(exerciseCategoryMapper.toEntity(dto)).getId();
    }

    @Override
    public List<UUID> saveAll(List<ExerciseCategorySaveDto> dtos) {
        return dtos.stream().map(this::save).toList();
    }

    @Override
    public void deleteById(UUID id) {
        exerciseCategoryRepository.deleteById(id);
    }
}

