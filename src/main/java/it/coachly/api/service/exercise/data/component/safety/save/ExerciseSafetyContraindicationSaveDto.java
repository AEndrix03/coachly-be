package it.coachly.api.service.exercise.data.component.safety.save;

import it.coachly.api.enums.safety.ContraindicationTypeEnum;
import it.coachly.api.service.exercise.data.component.safety.ExerciseSafetyContraindicationDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Map;
import java.util.UUID;

@Data
@SuperBuilder
public class ExerciseSafetyContraindicationSaveDto extends ExerciseSafetyContraindicationDto {
    private final UUID exerciseId;

    public ExerciseSafetyContraindicationSaveDto(UUID id, ContraindicationTypeEnum contraindicationType, String conditionName, Map<String, String> warningTextI18n, UUID exerciseId) {
        super(id, contraindicationType, conditionName, warningTextI18n);
        this.exerciseId = exerciseId;
    }
}

