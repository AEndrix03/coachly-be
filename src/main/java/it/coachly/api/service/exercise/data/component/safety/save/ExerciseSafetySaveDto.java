package it.coachly.api.service.exercise.data.component.safety.save;

import it.coachly.api.enums.safety.RiskLevelEnum;
import it.coachly.api.service.exercise.data.component.safety.ExerciseSafetyDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Map;
import java.util.UUID;

@Data
@SuperBuilder
public class ExerciseSafetySaveDto extends ExerciseSafetyDto {
    private final UUID exerciseId;

    public ExerciseSafetySaveDto(UUID id, RiskLevelEnum overallRiskLevel, Boolean spotterRequired, Map<String, String> safetyNotesI18n, UUID exerciseId) {
        super(id, overallRiskLevel, spotterRequired, safetyNotesI18n);
        this.exerciseId = exerciseId;
    }
}

