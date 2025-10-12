package it.coachly.api.service.exercise.data.component.metrics.save;

import it.coachly.api.service.exercise.data.component.metrics.ExerciseMetricDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@SuperBuilder
public class ExerciseMetricSaveDto extends ExerciseMetricDto {
    private final UUID exerciseId;

    public ExerciseMetricSaveDto(UUID id, Integer popularityScore, Integer usageCount, UUID exerciseId) {
        super(id, popularityScore, usageCount);
        this.exerciseId = exerciseId;
    }
}

