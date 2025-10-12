package it.coachly.api.service.exercise.mapper.component.core;

import it.coachly.api.model.exercise.metrics.ExerciseMetric;
import it.coachly.api.service.exercise.data.component.metrics.save.ExerciseMetricSaveDto;
import it.coachly.api.util.mapper.IEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class ExerciseMetricMapper implements IEntityMapper<ExerciseMetricSaveDto, ExerciseMetric> {
    @Override
    public ExerciseMetric toEntity(ExerciseMetricSaveDto dto) {
        return ExerciseMetric.builder()
                .id(dto.getId())
                .exerciseId(dto.getExerciseId())
                .popularityScore(dto.getPopularityScore())
                .usageCount(dto.getUsageCount())
                .build();
    }
}

