package it.coachly.api.service.exercise.component.core;

import it.aredegalli.common.exception.NotFoundException;
import it.coachly.api.repository.exercise.core.ExerciseRepository;
import it.coachly.api.repository.exercise.core.ExerciseVariationRepository;
import it.coachly.api.service.exercise.data.component.core.save.ExerciseVariantSaveDto;
import it.coachly.api.service.exercise.mapper.component.core.ExerciseVariationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExerciseVariationServiceImpl implements ExerciseVariationService {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseVariationRepository exerciseVariationRepository;
    private final ExerciseVariationMapper exerciseVariationMapper;

    @Override
    public UUID save(ExerciseVariantSaveDto dto) {
        this.exerciseRepository.findById(dto.getBaseExerciseId())
                .orElseThrow(() -> new NotFoundException("Base Exercise not found"));
        this.exerciseRepository.findById(dto.getVariantExerciseId())
                .orElseThrow(() -> new NotFoundException("Variant Exercise not found"));
        return exerciseVariationRepository.save(exerciseVariationMapper.toEntity(dto)).getId();
    }

    @Override
    public void deleteById(UUID id) {
        exerciseVariationRepository.deleteById(id);
    }
}

