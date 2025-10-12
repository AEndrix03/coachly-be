package it.coachly.api.service.exercise.mapper.component.core;

import it.coachly.api.model.exercise.core.ExerciseEnvironment;
import it.coachly.api.service.exercise.data.component.core.save.ExerciseEnvironmentSaveDto;
import it.coachly.api.util.mapper.IEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class ExerciseEnvironmentMapper implements IEntityMapper<ExerciseEnvironmentSaveDto, ExerciseEnvironment> {

    @Override
    public ExerciseEnvironment toEntity(ExerciseEnvironmentSaveDto dto) {
        return ExerciseEnvironment.builder()
                .id(dto.getId())
                .exerciseId(dto.getExerciseId())
                .canDoAtHome(dto.getCanDoAtHome())
                .canDoInGym(dto.getCanDoInGym())
                .equipmentSetupRequired(dto.getEquipmentSetupRequired())
                .build();
    }
}
