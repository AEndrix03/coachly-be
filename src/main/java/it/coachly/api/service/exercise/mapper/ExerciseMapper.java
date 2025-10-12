package it.coachly.api.service.exercise.mapper;

import it.coachly.api.model.exercise.core.Exercise;
import it.coachly.api.service.exercise.data.save.ExerciseSaveDto;
import it.coachly.api.util.mapper.IEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class ExerciseMapper implements IEntityMapper<ExerciseSaveDto, Exercise> {

    @Override
    public Exercise toEntity(ExerciseSaveDto dto) {
        return Exercise.builder()
                .id(dto.getId())
                .nameI18n(dto.getNamei18n())
                .descriptionI18n(dto.getDescriptioni18n())
                .tipsI18n(dto.getTipsi18n())
                .difficultyLevel(dto.getDifficultyLevel())
                .mechanicsType(dto.getMechanicsType())
                .forceType(dto.getForceType())
                .isUnilateral(dto.getIsUnilateral())
                .isBodyweight(dto.getIsBodyweight())
                .build();
    }

}
