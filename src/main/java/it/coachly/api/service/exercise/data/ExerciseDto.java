package it.coachly.api.service.exercise.data;

import com.querydsl.core.annotations.QueryProjection;
import it.coachly.api.enums.DifficultyLevelEnum;
import it.coachly.api.enums.exercise.ForceTypeEnum;
import it.coachly.api.enums.exercise.MechanicsTypeEnum;
import it.coachly.api.model.exercise.core.QExercise;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Map;
import java.util.UUID;

@Data
@SuperBuilder
@NoArgsConstructor
public class ExerciseDto {

    private UUID id;
    private Map<String, String> namei18n;
    private Map<String, String> descriptioni18n;
    private Map<String, String> tipsi18n;
    private DifficultyLevelEnum difficultyLevel;
    private MechanicsTypeEnum mechanicsType;
    private ForceTypeEnum forceType;
    private Boolean isUnilateral;
    private Boolean isBodyweight;

    @QueryProjection
    public ExerciseDto(UUID id, Map<String, String> namei18n, Map<String, String> descriptioni18n, Map<String, String> tipsi18n, DifficultyLevelEnum difficultyLevel, MechanicsTypeEnum mechanicsType, ForceTypeEnum forceType, Boolean isUnilateral, Boolean isBodyweight) {
        this.id = id;
        this.namei18n = namei18n;
        this.descriptioni18n = descriptioni18n;
        this.tipsi18n = tipsi18n;
        this.difficultyLevel = difficultyLevel;
        this.mechanicsType = mechanicsType;
        this.forceType = forceType;
        this.isUnilateral = isUnilateral;
        this.isBodyweight = isBodyweight;
    }

    public ExerciseDto(ExerciseDto other) {
        this.id = other.id;
        this.namei18n = other.namei18n;
        this.descriptioni18n = other.descriptioni18n;
        this.tipsi18n = other.tipsi18n;
        this.difficultyLevel = other.difficultyLevel;
        this.mechanicsType = other.mechanicsType;
        this.forceType = other.forceType;
        this.isUnilateral = other.isUnilateral;
        this.isBodyweight = other.isBodyweight;
    }

    public static QExerciseDto getProjection() {
        QExercise qE = QExercise.exercise;
        return new QExerciseDto(
                qE.id,
                qE.nameI18n,
                qE.descriptionI18n,
                qE.tipsI18n,
                qE.difficultyLevel,
                qE.mechanicsType,
                qE.forceType,
                qE.isUnilateral,
                qE.isBodyweight
        );
    }
}
