package it.coachly.api.service.exercise.mapper.component.core;

import it.coachly.api.model.exercise.safety.ExerciseSafetyContraindication;
import it.coachly.api.service.exercise.data.component.safety.save.ExerciseSafetyContraindicationSaveDto;
import it.coachly.api.util.mapper.IEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class ExerciseSafetyContraindicationMapper implements IEntityMapper<ExerciseSafetyContraindicationSaveDto, ExerciseSafetyContraindication> {
    @Override
    public ExerciseSafetyContraindication toEntity(ExerciseSafetyContraindicationSaveDto dto) {
        return ExerciseSafetyContraindication.builder()
                .id(dto.getId())
                .exerciseId(dto.getExerciseId())
                .contraindicationType(dto.getContraindicationType())
                .conditionName(dto.getConditionName())
                .warningTextI18n(dto.getWarningTextI18n())
                .build();
    }
}

