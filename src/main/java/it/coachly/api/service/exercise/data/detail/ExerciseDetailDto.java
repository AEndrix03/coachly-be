package it.coachly.api.service.exercise.data.detail;

import it.coachly.api.enums.DifficultyLevelEnum;
import it.coachly.api.enums.exercise.ForceTypeEnum;
import it.coachly.api.enums.exercise.MechanicsTypeEnum;
import it.coachly.api.service.exercise.data.ExerciseDto;
import it.coachly.api.service.exercise.data.component.category.ExerciseCategoryDto;
import it.coachly.api.service.exercise.data.component.core.ExerciseEnvironmentDto;
import it.coachly.api.service.exercise.data.component.core.ExerciseInstructionDto;
import it.coachly.api.service.exercise.data.component.core.ExerciseMovementPatternDto;
import it.coachly.api.service.exercise.data.component.core.ExerciseVariantDto;
import it.coachly.api.service.exercise.data.detail.builder.ExerciseDetailDtoBuilder;
import it.coachly.api.service.exercise.data.component.equipment.ExerciseEquipmentDto;
import it.coachly.api.service.exercise.data.component.media.ExerciseMediaDto;
import it.coachly.api.service.exercise.data.component.muscle.ExerciseMuscleDto;
import it.coachly.api.service.exercise.data.component.safety.ExerciseSafetyContraindicationDto;
import it.coachly.api.service.exercise.data.component.safety.ExerciseSafetyDto;
import it.coachly.api.service.tag.data.TagDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ExerciseDetailDto extends ExerciseDto {

    private ExerciseEnvironmentDto environment;
    private List<ExerciseInstructionDto> instructions;
    private ExerciseMovementPatternDto movementPattern;
    private List<ExerciseVariantDto> variants;
    private List<ExerciseMediaDto> media;
    private List<ExerciseCategoryDto> categories;
    private List<ExerciseSafetyDto> safety;
    private List<ExerciseSafetyContraindicationDto> safetyContraindications;
    private List<ExerciseMuscleDto> muscles;
    private List<ExerciseEquipmentDto> equipments;
    private List<TagDto> tags;

    public ExerciseDetailDto(UUID id, Map<String, String> namei18n, Map<String, String> descriptioni18n, Map<String, String> tipsi18n, DifficultyLevelEnum difficultyLevel, MechanicsTypeEnum mechanicsType, ForceTypeEnum forceType, Boolean isUnilateral, Boolean isBodyweight, ExerciseEnvironmentDto environment, List<ExerciseInstructionDto> instructions, ExerciseMovementPatternDto movementPattern, List<ExerciseVariantDto> variants, List<ExerciseMediaDto> media, List<ExerciseCategoryDto> categories, List<ExerciseSafetyDto> safety, List<ExerciseSafetyContraindicationDto> safetyContraindications, List<ExerciseMuscleDto> muscles, List<ExerciseEquipmentDto> equipments, List<TagDto> tags) {
        super(id, namei18n, descriptioni18n, tipsi18n, difficultyLevel, mechanicsType, forceType, isUnilateral, isBodyweight);
        this.environment = environment;
        this.instructions = instructions;
        this.movementPattern = movementPattern;
        this.variants = variants;
        this.media = media;
        this.categories = categories;
        this.safety = safety;
        this.safetyContraindications = safetyContraindications;
        this.muscles = muscles;
        this.equipments = equipments;
        this.tags = tags;
    }

    public ExerciseDetailDto(ExerciseDto other, ExerciseEnvironmentDto environment, List<ExerciseInstructionDto> instructions, ExerciseMovementPatternDto movementPattern, List<ExerciseVariantDto> variants, List<ExerciseMediaDto> media, List<ExerciseCategoryDto> categories, List<ExerciseSafetyDto> safety, List<ExerciseSafetyContraindicationDto> safetyContraindications, List<ExerciseMuscleDto> muscles, List<ExerciseEquipmentDto> equipments, List<TagDto> tags) {
        super(other);
        this.environment = environment;
        this.instructions = instructions;
        this.movementPattern = movementPattern;
        this.variants = variants;
        this.media = media;
        this.categories = categories;
        this.safety = safety;
        this.safetyContraindications = safetyContraindications;
        this.muscles = muscles;
        this.equipments = equipments;
        this.tags = tags;
    }

    public static ExerciseDetailDtoBuilder builderDetail() {
        return new ExerciseDetailDtoBuilder();
    }
}
