package it.coachly.api.service.exercise.component.media;

import it.aredegalli.common.exception.NotFoundException;
import it.coachly.api.repository.exercise.core.ExerciseRepository;
import it.coachly.api.repository.exercise.media.ExerciseMediaRepository;
import it.coachly.api.service.exercise.data.component.media.ExerciseMediaDto;
import it.coachly.api.service.exercise.data.component.media.save.ExerciseMediaSaveDto;
import it.coachly.api.service.exercise.finder.component.media.ExerciseMediaFinder;
import it.coachly.api.service.exercise.mapper.component.media.ExerciseMediaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExerciseMediaServiceImpl implements ExerciseMediaService {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseMediaRepository exerciseMediaRepository;
    private final ExerciseMediaMapper exerciseMediaMapper;
    private final ExerciseMediaFinder exerciseMediaFinder;

    @Override
    public UUID save(ExerciseMediaSaveDto dto) {
        this.exerciseRepository.findById(dto.getExerciseId())
                .orElseThrow(() -> new NotFoundException("Exercise not found"));
        return exerciseMediaRepository.save(exerciseMediaMapper.toEntity(dto)).getId();
    }

    @Override
    public List<UUID> saveAll(List<ExerciseMediaSaveDto> dtos) {
        return dtos.stream().map(this::save).toList();
    }

    @Override
    public void deleteById(UUID id) {
        exerciseMediaRepository.deleteById(id);
    }

    @Override
    public List<ExerciseMediaDto> getExerciseMedia(UUID exerciseId) {
        return exerciseMediaFinder.findExerciseMedia(exerciseId);
    }
}
