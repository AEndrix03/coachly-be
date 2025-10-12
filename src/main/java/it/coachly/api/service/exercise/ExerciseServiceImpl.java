package it.coachly.api.service.exercise;

import it.coachly.api.repository.exercise.core.ExerciseRepository;
import it.coachly.api.service.exercise.data.ExerciseDto;
import it.coachly.api.service.exercise.data.detail.ExerciseDetailDto;
import it.coachly.api.service.exercise.finder.ExerciseFinder;
import it.coachly.api.service.exercise.finder.detail.ExerciseDetailFinder;
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

    @Override
    public Page<ExerciseDto> getPaginated(Pageable pageable) {
        return this.exerciseFinder.findPaginated(pageable);
    }

    @Override
    public ExerciseDetailDto getDetailById(UUID id) {
        return this.exerciseDetailFinder.findDetailById(id);
    }


}
