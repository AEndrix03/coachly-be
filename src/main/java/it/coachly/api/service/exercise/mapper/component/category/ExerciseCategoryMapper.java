package it.coachly.api.service.exercise.mapper.component.category;

import it.coachly.api.model.exercise.category.ExerciseCategory;
import it.coachly.api.service.exercise.data.component.category.save.ExerciseCategorySaveDto;
import it.coachly.api.util.mapper.IEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class ExerciseCategoryMapper implements IEntityMapper<ExerciseCategorySaveDto, ExerciseCategory> {
    @Override
    public ExerciseCategory toEntity(ExerciseCategorySaveDto dto) {
        return ExerciseCategory.builder()
                .id(dto.getId())
                .code(dto.getCode())
                .nameI18n(dto.getNameI18n())
                .descriptionI18n(dto.getDescriptionI18n())
                .categoryLevel(dto.getCategoryLevel())
                .build();
    }
}

