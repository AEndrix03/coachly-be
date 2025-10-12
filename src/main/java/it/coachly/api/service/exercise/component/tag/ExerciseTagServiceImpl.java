package it.coachly.api.service.exercise.component.tag;

import it.aredegalli.common.exception.NotFoundException;
import it.coachly.api.model.tag.exercise.ExerciseTagId;
import it.coachly.api.repository.exercise.core.ExerciseRepository;
import it.coachly.api.repository.tag.exercise.ExerciseTagRepository;
import it.coachly.api.service.exercise.data.component.tag.save.ExerciseTagSaveDto;
import it.coachly.api.service.exercise.mapper.component.tag.ExerciseTagMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExerciseTagServiceImpl implements ExerciseTagService {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseTagRepository exerciseTagRepository;
    private final ExerciseTagMapper exerciseTagMapper;

    @Override
    public void save(ExerciseTagSaveDto dto) {
        this.exerciseRepository.findById(dto.getExerciseId())
                .orElseThrow(() -> new NotFoundException("Exercise not found"));
        exerciseTagRepository.save(exerciseTagMapper.toEntity(dto));
    }

    @Override
    public List<Void> saveAll(List<ExerciseTagSaveDto> dtos) {
        dtos.forEach(this::save);
        return List.of();
    }

    @Override
    public void deleteById(UUID exerciseId, UUID tagId) {
        exerciseTagRepository.deleteById(new ExerciseTagId(exerciseId, tagId));
    }
}
