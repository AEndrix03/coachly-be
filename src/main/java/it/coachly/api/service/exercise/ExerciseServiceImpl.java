package it.coachly.api.service.exercise;

import it.coachly.api.repository.exercise.core.ExerciseRepository;
import it.coachly.api.service.exercise.data.ExerciseDto;
import it.coachly.api.service.exercise.data.detail.ExerciseDetailDto;
import it.coachly.api.service.exercise.data.save.ExerciseSaveDto;
import it.coachly.api.service.exercise.finder.ExerciseFinder;
import it.coachly.api.service.exercise.finder.detail.ExerciseDetailFinder;
import it.coachly.api.service.exercise.mapper.ExerciseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    private final ExerciseFinder exerciseFinder;
    private final ExerciseDetailFinder exerciseDetailFinder;

    private final ExerciseMapper exerciseMapper;

    @Override
    public Page<ExerciseDto> getPaginated(Pageable pageable) {
        return this.exerciseFinder.findPaginated(pageable);
    }

    @Override
    public ExerciseDetailDto getDetailById(UUID id) {
        return this.exerciseDetailFinder.findDetailById(id);
    }

    @Override
    public UUID save(ExerciseSaveDto dto) {
        return this.exerciseRepository.save(this.exerciseMapper.toEntity(dto)).getId();
    }

    @Override
    public void deleteById(UUID id) {
        this.exerciseRepository.deleteById(id);
    }

}
