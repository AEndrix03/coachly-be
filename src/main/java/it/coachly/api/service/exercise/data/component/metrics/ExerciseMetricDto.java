package it.coachly.api.service.exercise.data.component.metrics;

import com.querydsl.core.annotations.QueryProjection;
import it.coachly.api.model.exercise.metrics.QExerciseMetric;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ExerciseMetricDto {

    private UUID id;
    private Integer popularityScore;
    private Integer usageCount;

    @QueryProjection
    public ExerciseMetricDto(UUID id, Integer popularityScore, Integer usageCount) {
        this.id = id;
        this.popularityScore = popularityScore;
        this.usageCount = usageCount;
    }

    public static QExerciseMetricDto getProjection() {
        QExerciseMetric qEM = QExerciseMetric.exerciseMetric;
        return new QExerciseMetricDto(
                qEM.id,
                qEM.popularityScore,
                qEM.usageCount
        );
    }
}
