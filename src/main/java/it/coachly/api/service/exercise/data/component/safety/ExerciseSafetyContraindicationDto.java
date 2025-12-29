package it.coachly.api.service.exercise.data.component.safety;

import com.querydsl.core.annotations.QueryProjection;
import it.coachly.api.enums.safety.ContraindicationTypeEnum;
import it.coachly.api.model.exercise.safety.QExerciseSafetyContraindication;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Map;
import java.util.UUID;

@Data
@SuperBuilder
@NoArgsConstructor
public class ExerciseSafetyContraindicationDto {

    private UUID id;

    private ContraindicationTypeEnum contraindicationType;
    private String conditionName;
    private Map<String, String> warningTextI18n;

    @QueryProjection
    public ExerciseSafetyContraindicationDto(UUID id, ContraindicationTypeEnum contraindicationType, String conditionName, Map<String, String> warningTextI18n) {
        this.id = id;
        this.contraindicationType = contraindicationType;
        this.conditionName = conditionName;
        this.warningTextI18n = warningTextI18n;
    }

    public static QExerciseSafetyContraindicationDto getProjection() {
        QExerciseSafetyContraindication qESD = QExerciseSafetyContraindication.exerciseSafetyContraindication;
        return new QExerciseSafetyContraindicationDto(
                qESD.id,
                qESD.contraindicationType,
                qESD.conditionName,
                qESD.warningTextI18n
        );
    }
}
