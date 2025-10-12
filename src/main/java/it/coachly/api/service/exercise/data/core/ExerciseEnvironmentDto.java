package it.coachly.api.service.exercise.data.core;

import com.querydsl.core.annotations.QueryProjection;
import it.coachly.api.model.exercise.core.QExerciseEnvironment;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ExerciseEnvironmentDto {

    private UUID id;
    private Boolean canDoAtHome;
    private Boolean canDoInGym;
    private Boolean equipmentSetupRequired;

    @QueryProjection
    public ExerciseEnvironmentDto(UUID id, Boolean canDoAtHome, Boolean canDoInGym, Boolean equipmentSetupRequired) {
        this.id = id;
        this.canDoAtHome = canDoAtHome;
        this.canDoInGym = canDoInGym;
        this.equipmentSetupRequired = equipmentSetupRequired;
    }

    public static QExerciseEnvironmentDto getProjection() {
        QExerciseEnvironment qEE = QExerciseEnvironment.exerciseEnvironment;
        return new QExerciseEnvironmentDto(
                qEE.id,
                qEE.canDoAtHome,
                qEE.canDoInGym,
                qEE.equipmentSetupRequired
        );
    }


}
