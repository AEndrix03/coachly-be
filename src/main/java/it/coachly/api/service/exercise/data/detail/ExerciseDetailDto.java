package it.coachly.api.service.exercise.data.detail;

import it.coachly.api.enums.DifficultyLevelEnum;
import it.coachly.api.enums.exercise.ForceTypeEnum;
import it.coachly.api.enums.exercise.MechanicsTypeEnum;
import it.coachly.api.service.exercise.data.ExerciseDto;
import it.coachly.api.service.exercise.data.category.ExerciseCategoryDto;
import it.coachly.api.service.exercise.data.core.ExerciseEnvironmentDto;
import it.coachly.api.service.exercise.data.core.ExerciseInstructionDto;
import it.coachly.api.service.exercise.data.core.ExerciseMovementPatternDto;
import it.coachly.api.service.exercise.data.core.ExerciseVariantDto;
import it.coachly.api.service.exercise.data.detail.builder.ExerciseDetailDtoBuilder;
import it.coachly.api.service.exercise.data.media.ExerciseMediaDto;
import it.coachly.api.service.exercise.data.safety.ExerciseSafetyContraindicationDto;
import it.coachly.api.service.exercise.data.safety.ExerciseSafetyDto;
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

    public ExerciseDetailDto(UUID id, Map<String, String> namei18n, Map<String, String> descriptioni18n, Map<String, String> tipsi18n, DifficultyLevelEnum difficultyLevel, MechanicsTypeEnum mechanicsType, ForceTypeEnum forceType, Boolean isUnilateral, Boolean isBodyweight, ExerciseEnvironmentDto environment, List<ExerciseInstructionDto> instructions, ExerciseMovementPatternDto movementPattern, List<ExerciseVariantDto> variants, List<ExerciseMediaDto> media, List<ExerciseCategoryDto> categories, List<ExerciseSafetyDto> safety, List<ExerciseSafetyContraindicationDto> safetyContraindications) {
        super(id, namei18n, descriptioni18n, tipsi18n, difficultyLevel, mechanicsType, forceType, isUnilateral, isBodyweight);
        this.environment = environment;
        this.instructions = instructions;
        this.movementPattern = movementPattern;
        this.variants = variants;
        this.media = media;
        this.categories = categories;
        this.safety = safety;
        this.safetyContraindications = safetyContraindications;
    }

    public ExerciseDetailDto(ExerciseDto other, ExerciseEnvironmentDto environment, List<ExerciseInstructionDto> instructions, ExerciseMovementPatternDto movementPattern, List<ExerciseVariantDto> variants, List<ExerciseMediaDto> media, List<ExerciseCategoryDto> categories, List<ExerciseSafetyDto> safety, List<ExerciseSafetyContraindicationDto> safetyContraindications) {
        super(other);
        this.environment = environment;
        this.instructions = instructions;
        this.movementPattern = movementPattern;
        this.variants = variants;
        this.media = media;
        this.categories = categories;
        this.safety = safety;
        this.safetyContraindications = safetyContraindications;
    }

    public static ExerciseDetailDtoBuilder builderDetail() {
        return new ExerciseDetailDtoBuilder();
    }
}
