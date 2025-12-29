package it.coachly.api.service.exercise.data.component.core;

import com.querydsl.core.annotations.QueryProjection;
import it.coachly.api.enums.DifficultyLevelEnum;
import it.coachly.api.enums.exercise.ForceTypeEnum;
import it.coachly.api.enums.exercise.MechanicsTypeEnum;
import it.coachly.api.enums.exercise.VariationTypeEnum;
import it.coachly.api.model.exercise.core.QExerciseVariation;
import it.coachly.api.service.exercise.data.ExerciseDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Map;
import java.util.UUID;

@Data
@SuperBuilder
@NoArgsConstructor
public class ExerciseVariantDto extends ExerciseDto {

    private VariationTypeEnum variationType;
    private Integer difficultyDelta;

    @QueryProjection
    public ExerciseVariantDto(UUID id, Map<String, String> namei18n, Map<String, String> descriptioni18n, Map<String, String> tipsi18n, DifficultyLevelEnum difficultyLevel, MechanicsTypeEnum mechanicsType, ForceTypeEnum forceType, Boolean isUnilateral, Boolean isBodyweight, VariationTypeEnum variationType, Integer difficultyDelta) {
        super(id, namei18n, descriptioni18n, tipsi18n, difficultyLevel, mechanicsType, forceType, isUnilateral, isBodyweight);
        this.variationType = variationType;
        this.difficultyDelta = difficultyDelta;
    }

    public static QExerciseVariantDto getVariatProjection() {
        QExerciseVariation qEV = QExerciseVariation.exerciseVariation;
        return new QExerciseVariantDto(
                qEV.variantExercise.id,
                qEV.variantExercise.nameI18n,
                qEV.variantExercise.descriptionI18n,
                qEV.variantExercise.tipsI18n,
                qEV.variantExercise.difficultyLevel,
                qEV.variantExercise.mechanicsType,
                qEV.variantExercise.forceType,
                qEV.variantExercise.isUnilateral,
                qEV.variantExercise.isBodyweight,
                qEV.variationType,
                qEV.difficultyDelta
        );
    }
}
