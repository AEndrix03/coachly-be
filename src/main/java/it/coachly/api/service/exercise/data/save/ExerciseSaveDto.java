package it.coachly.api.service.exercise.data.save;

import it.coachly.api.enums.DifficultyLevelEnum;
import it.coachly.api.enums.exercise.ForceTypeEnum;
import it.coachly.api.enums.exercise.MechanicsTypeEnum;
import it.coachly.api.service.exercise.data.ExerciseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.Map;
import java.util.UUID;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ExerciseSaveDto extends ExerciseDto {

    public ExerciseSaveDto(UUID id, Map<String, String> namei18n, Map<String, String> descriptioni18n, Map<String, String> tipsi18n, DifficultyLevelEnum difficultyLevel, MechanicsTypeEnum mechanicsType, ForceTypeEnum forceType, Boolean isUnilateral, Boolean isBodyweight) {
        super(id, namei18n, descriptioni18n, tipsi18n, difficultyLevel, mechanicsType, forceType, isUnilateral, isBodyweight);
    }
}
