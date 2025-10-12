package it.coachly.api.service.exercise.data.component.category.save;

import it.coachly.api.service.exercise.data.component.category.ExerciseCategoryDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@SuperBuilder
public class ExerciseCategorySaveDto extends ExerciseCategoryDto {
    private final UUID exerciseId;

    public ExerciseCategorySaveDto(UUID id, String code, Map<String, String> nameI18n, Map<String, String> descriptionI18n, Integer categoryLevel, Boolean isPrimary, List<ExerciseCategoryDto> children, UUID exerciseId) {
        super(id, code, nameI18n, descriptionI18n, categoryLevel, isPrimary);
        this.exerciseId = exerciseId;
        this.setChildren(children);
    }
}

