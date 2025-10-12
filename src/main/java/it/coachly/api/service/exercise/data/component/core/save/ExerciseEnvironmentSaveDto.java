package it.coachly.api.service.exercise.data.component.core.save;

import it.coachly.api.service.exercise.data.component.core.ExerciseEnvironmentDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@SuperBuilder
public class ExerciseEnvironmentSaveDto extends ExerciseEnvironmentDto {

    private UUID exerciseId;

    public ExerciseEnvironmentSaveDto(UUID id, Boolean canDoAtHome, Boolean canDoInGym, Boolean equipmentSetupRequired, UUID exerciseId) {
        super(id, canDoAtHome, canDoInGym, equipmentSetupRequired);
        this.exerciseId = exerciseId;
    }
}
