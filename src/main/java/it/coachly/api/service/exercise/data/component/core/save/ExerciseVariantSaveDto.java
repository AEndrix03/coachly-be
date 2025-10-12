package it.coachly.api.service.exercise.data.component.core.save;

import it.coachly.api.enums.DifficultyLevelEnum;
import it.coachly.api.enums.exercise.ForceTypeEnum;
import it.coachly.api.enums.exercise.MechanicsTypeEnum;
import it.coachly.api.enums.exercise.VariationTypeEnum;
import it.coachly.api.service.exercise.data.component.core.ExerciseVariantDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Map;
import java.util.UUID;

@Data
@SuperBuilder
public class ExerciseVariantSaveDto extends ExerciseVariantDto {
    private final UUID baseExerciseId;
    private final UUID variantExerciseId;

    public ExerciseVariantSaveDto(UUID id, Map<String, String> namei18n, Map<String, String> descriptioni18n, Map<String, String> tipsi18n, DifficultyLevelEnum difficultyLevel, MechanicsTypeEnum mechanicsType, ForceTypeEnum forceType, Boolean isUnilateral, Boolean isBodyweight, VariationTypeEnum variationType, UUID variantExerciseId, UUID baseExerciseId) {
        super(id, namei18n, descriptioni18n, tipsi18n, difficultyLevel, mechanicsType, forceType, isUnilateral, isBodyweight, variationType);
        this.variantExerciseId = variantExerciseId;
        this.baseExerciseId = baseExerciseId;
    }
}

