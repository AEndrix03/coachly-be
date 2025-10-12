package it.coachly.api.service.exercise.mapper.component.muscle;

import it.coachly.api.model.muscle.exercise.ExerciseMuscle;
import it.coachly.api.service.exercise.data.component.muscle.save.ExerciseMuscleSaveDto;
import it.coachly.api.util.mapper.IEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class ExerciseMuscleMapper implements IEntityMapper<ExerciseMuscleSaveDto, ExerciseMuscle> {
    @Override
    public ExerciseMuscle toEntity(ExerciseMuscleSaveDto dto) {
        return ExerciseMuscle.builder()
                .exerciseId(dto.getExerciseId())
                .muscleId(dto.getMuscleId())
                .involvementLevel(dto.getInvolvementLevel())
                .primaryContractionTypeId(dto.getPrimaryContractionTypeId())
                .activationPercentage(dto.getActivationPercentage())
                .build();
    }
}

