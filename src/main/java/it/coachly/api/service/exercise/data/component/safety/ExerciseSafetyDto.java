package it.coachly.api.service.exercise.data.component.safety;

import com.querydsl.core.annotations.QueryProjection;
import it.coachly.api.enums.safety.RiskLevelEnum;
import it.coachly.api.model.exercise.safety.QExerciseSafety;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Map;
import java.util.UUID;

@Data
@SuperBuilder
public class ExerciseSafetyDto {

    private UUID id;
    private RiskLevelEnum overallRiskLevel;
    private Boolean spotterRequired;
    private Map<String, String> safetyNotesI18n;

    @QueryProjection
    public ExerciseSafetyDto(UUID id, RiskLevelEnum overallRiskLevel, Boolean spotterRequired, Map<String, String> safetyNotesI18n) {
        this.id = id;
        this.overallRiskLevel = overallRiskLevel;
        this.spotterRequired = spotterRequired;
        this.safetyNotesI18n = safetyNotesI18n;
    }

    public static QExerciseSafetyDto getProjection() {
        QExerciseSafety qES = QExerciseSafety.exerciseSafety;
        return new QExerciseSafetyDto(
                qES.id,
                qES.overallRiskLevel,
                qES.spotterRequired,
                qES.safetyNotesI18n
        );
    }
}
