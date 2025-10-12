package it.coachly.api.service.exercise.data.component.muscle;

import com.querydsl.core.annotations.QueryProjection;
import it.coachly.api.enums.muscle.InvolvementLevelEnum;
import it.coachly.api.model.muscle.exercise.QExerciseMuscle;
import it.coachly.api.service.muscle.data.ContractionTypeDto;
import it.coachly.api.service.muscle.data.MuscleDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExerciseMuscleDto {

    private MuscleDto muscle;
    private InvolvementLevelEnum involvementLevel;
    private ContractionTypeDto primaryContractionType;
    private Integer activationPercentage;

    @QueryProjection
    public ExerciseMuscleDto(MuscleDto muscle, InvolvementLevelEnum involvementLevel, ContractionTypeDto primaryContractionType, Integer activationPercentage) {
        this.muscle = muscle;
        this.involvementLevel = involvementLevel;
        this.primaryContractionType = primaryContractionType;
        this.activationPercentage = activationPercentage;
    }

    public static QExerciseMuscleDto getProjection() {
        return new QExerciseMuscleDto(
                MuscleDto.getProjection(),
                QExerciseMuscle.exerciseMuscle.involvementLevel,
                ContractionTypeDto.getProjection(),
                QExerciseMuscle.exerciseMuscle.activationPercentage
        );
    }

}
