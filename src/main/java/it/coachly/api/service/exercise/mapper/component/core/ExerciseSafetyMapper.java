package it.coachly.api.service.exercise.mapper.component.core;

import it.coachly.api.model.exercise.safety.ExerciseSafety;
import it.coachly.api.service.exercise.data.component.safety.save.ExerciseSafetySaveDto;
import it.coachly.api.util.mapper.IEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class ExerciseSafetyMapper implements IEntityMapper<ExerciseSafetySaveDto, ExerciseSafety> {
    @Override
    public ExerciseSafety toEntity(ExerciseSafetySaveDto dto) {
        return ExerciseSafety.builder()
                .id(dto.getId())
                .exerciseId(dto.getExerciseId())
                .overallRiskLevel(dto.getOverallRiskLevel())
                .spotterRequired(dto.getSpotterRequired())
                .safetyNotesI18n(dto.getSafetyNotesI18n())
                .build();
    }
}

