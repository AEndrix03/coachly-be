package it.coachly.api.service.exercise.data.component.category;

import com.querydsl.core.annotations.QueryProjection;
import it.coachly.api.model.exercise.category.QExerciseCategory;
import it.coachly.api.model.exercise.category.QExerciseCategoryMapping;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class ExerciseCategoryDto {

    private UUID id;
    private String code;
    private Map<String, String> nameI18n;
    private Map<String, String> descriptionI18n;
    private Integer categoryLevel;
    private Boolean isPrimary;

    private List<ExerciseCategoryDto> children;

    @QueryProjection
    public ExerciseCategoryDto(UUID id, String code, Map<String, String> nameI18n, Map<String, String> descriptionI18n, Integer categoryLevel, Boolean isPrimary) {
        this.id = id;
        this.code = code;
        this.nameI18n = nameI18n;
        this.descriptionI18n = descriptionI18n;
        this.categoryLevel = categoryLevel;
        this.isPrimary = isPrimary;
    }

    @QueryProjection
    public ExerciseCategoryDto(UUID id, String code, Map<String, String> nameI18n, Map<String, String> descriptionI18n, Integer categoryLevel) {
        this.id = id;
        this.code = code;
        this.nameI18n = nameI18n;
        this.descriptionI18n = descriptionI18n;
        this.categoryLevel = categoryLevel;
    }

    public static QExerciseCategoryDto getProjection() {
        QExerciseCategory qEC = QExerciseCategory.exerciseCategory;
        QExerciseCategoryMapping qECM = QExerciseCategoryMapping.exerciseCategoryMapping;
        return new QExerciseCategoryDto(
                qEC.id,
                qEC.code,
                qEC.nameI18n,
                qEC.descriptionI18n,
                qEC.categoryLevel,
                qECM.isPrimaryCategory
        );
    }

    public static QExerciseCategoryDto getBaseProjection() {
        QExerciseCategory qEC = QExerciseCategory.exerciseCategory;
        return new QExerciseCategoryDto(
                qEC.id,
                qEC.code,
                qEC.nameI18n,
                qEC.descriptionI18n,
                qEC.categoryLevel
        );
    }

}
