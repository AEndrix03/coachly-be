package it.coachly.api.service.exercise.data.detail.builder;

import it.coachly.api.service.exercise.data.ExerciseDto;
import it.coachly.api.service.exercise.data.category.ExerciseCategoryDto;
import it.coachly.api.service.exercise.data.core.ExerciseEnvironmentDto;
import it.coachly.api.service.exercise.data.core.ExerciseInstructionDto;
import it.coachly.api.service.exercise.data.core.ExerciseMovementPatternDto;
import it.coachly.api.service.exercise.data.core.ExerciseVariantDto;
import it.coachly.api.service.exercise.data.detail.ExerciseDetailDto;
import it.coachly.api.service.exercise.data.equipment.ExerciseEquipmentDto;
import it.coachly.api.service.exercise.data.media.ExerciseMediaDto;
import it.coachly.api.service.exercise.data.muscle.ExerciseMuscleDto;
import it.coachly.api.service.exercise.data.safety.ExerciseSafetyContraindicationDto;
import it.coachly.api.service.exercise.data.safety.ExerciseSafetyDto;
import it.coachly.api.service.tag.data.TagDto;

import java.util.List;

public class ExerciseDetailDtoBuilder {

    private ExerciseDto baseExercise;
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

    public ExerciseDetailDtoBuilder withBaseExercise(ExerciseDto baseExercise) {
        this.baseExercise = baseExercise;
        return this;
    }

    public ExerciseDetailDtoBuilder withEnvironment(ExerciseEnvironmentDto environment) {
        this.environment = environment;
        return this;
    }

    public ExerciseDetailDtoBuilder withInstructions(List<ExerciseInstructionDto> instructions) {
        this.instructions = instructions;
        return this;
    }

    public ExerciseDetailDtoBuilder withMovementPattern(ExerciseMovementPatternDto movementPattern) {
        this.movementPattern = movementPattern;
        return this;
    }

    public ExerciseDetailDtoBuilder withVariants(List<ExerciseVariantDto> variants) {
        this.variants = variants;
        return this;
    }

    public ExerciseDetailDtoBuilder withMedia(List<ExerciseMediaDto> media) {
        this.media = media;
        return this;
    }

    public ExerciseDetailDtoBuilder withCategories(List<ExerciseCategoryDto> categories) {
        this.categories = categories;
        return this;
    }

    public ExerciseDetailDtoBuilder withSafety(List<ExerciseSafetyDto> safety) {
        this.safety = safety;
        return this;
    }

    public ExerciseDetailDtoBuilder withSafetyContraindications(List<ExerciseSafetyContraindicationDto> safetyContraindications) {
        this.safetyContraindications = safetyContraindications;
        return this;
    }

    public ExerciseDetailDtoBuilder withMuscles(List<ExerciseMuscleDto> muscles) {
        this.muscles = muscles;
        return this;
    }

    public ExerciseDetailDtoBuilder withEquipments(List<ExerciseEquipmentDto> equipments) {
        this.equipments = equipments;
        return this;
    }

    public ExerciseDetailDtoBuilder withTags(List<TagDto> tags) {
        this.tags = tags;
        return this;
    }

    public ExerciseDetailDto build() {
        return new ExerciseDetailDto(
                baseExercise,
                environment,
                instructions,
                movementPattern,
                variants,
                media,
                categories,
                safety,
                safetyContraindications,
                muscles,
                equipments,
                tags
        );
    }


}
