package it.coachly.api.service.exercise.mapper.component.core;

import it.coachly.api.model.exercise.core.ExerciseVariation;
import it.coachly.api.service.exercise.data.component.core.save.ExerciseVariantSaveDto;
import it.coachly.api.util.mapper.IEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class ExerciseVariationMapper implements IEntityMapper<ExerciseVariantSaveDto, ExerciseVariation> {
    @Override
    public ExerciseVariation toEntity(ExerciseVariantSaveDto dto) {
        return ExerciseVariation.builder()
                .id(dto.getId())
                .baseExerciseId(dto.getBaseExerciseId())
                .variantExerciseId(dto.getVariantExerciseId())
                .variationType(dto.getVariationType())
                .difficultyDelta(dto.getDifficultyLevel())
                .build();
    }
}

