package it.coachly.api.service.exercise.data.core;

import com.querydsl.core.annotations.QueryProjection;
import it.coachly.api.enums.DifficultyLevelEnum;
import it.coachly.api.enums.exercise.ForceTypeEnum;
import it.coachly.api.enums.exercise.MechanicsTypeEnum;
import it.coachly.api.enums.exercise.VariationTypeEnum;
import it.coachly.api.model.exercise.core.QExerciseVariation;
import it.coachly.api.service.exercise.data.ExerciseDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Map;
import java.util.UUID;

@Data
@SuperBuilder
public class ExerciseVariantDto extends ExerciseDto {

    private VariationTypeEnum variationType;

    @QueryProjection
    public ExerciseVariantDto(UUID id, Map<String, String> namei18n, Map<String, String> descriptioni18n, Map<String, String> tipsi18n, DifficultyLevelEnum difficultyLevel, MechanicsTypeEnum mechanicsType, ForceTypeEnum forceType, Boolean isUnilateral, Boolean isBodyweight, VariationTypeEnum variationType) {
        super(id, namei18n, descriptioni18n, tipsi18n, difficultyLevel, mechanicsType, forceType, isUnilateral, isBodyweight);
        this.variationType = variationType;
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
                qEV.variationType
        );
    }
}
