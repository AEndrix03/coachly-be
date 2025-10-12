package it.coachly.api.service.exercise.mapper.component.tag;

import it.coachly.api.model.tag.exercise.ExerciseTag;
import it.coachly.api.model.tag.exercise.ExerciseTagId;
import it.coachly.api.service.exercise.data.component.tag.save.ExerciseTagSaveDto;
import it.coachly.api.util.mapper.IEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class ExerciseTagMapper implements IEntityMapper<ExerciseTagSaveDto, ExerciseTag> {
    @Override
    public ExerciseTag toEntity(ExerciseTagSaveDto dto) {
        return ExerciseTag.builder()
                .id(new ExerciseTagId(dto.getExerciseId(), dto.getTagId()))
                .build();
    }
}
