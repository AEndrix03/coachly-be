package it.coachly.api.service.exercise.finder.detail;

import it.coachly.api.service.exercise.data.detail.ExerciseDetailDto;
import it.coachly.api.service.exercise.finder.ExerciseFinder;
import it.coachly.api.service.exercise.finder.component.category.ExerciseCategoryFinder;
import it.coachly.api.service.exercise.finder.component.core.ExerciseEnvironmentFinder;
import it.coachly.api.service.exercise.finder.component.core.ExerciseInstructionFinder;
import it.coachly.api.service.exercise.finder.component.core.ExerciseMovementPatternFinder;
import it.coachly.api.service.exercise.finder.component.core.ExerciseVariantFinder;
import it.coachly.api.service.exercise.finder.component.equipment.ExerciseEquipmentFinder;
import it.coachly.api.service.exercise.finder.component.media.ExerciseMediaFinder;
import it.coachly.api.service.exercise.finder.component.muscle.ExerciseMuscleFinder;
import it.coachly.api.service.exercise.finder.component.safety.ExerciseSafetyContraindicationFinder;
import it.coachly.api.service.exercise.finder.component.safety.ExerciseSafetyFinder;
import it.coachly.api.service.exercise.finder.component.tag.ExerciseTagFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ExerciseDetailFinder {

    private final ExerciseFinder exerciseFinder;
    private final ExerciseCategoryFinder exerciseCategoryFinder;
    private final ExerciseMediaFinder exerciseMediaFinder;
    private final ExerciseMuscleFinder exerciseMuscleFinder;
    private final ExerciseEquipmentFinder exerciseEquipmentFinder;
    private final ExerciseTagFinder exerciseTagFinder;
    private final ExerciseSafetyFinder exerciseSafetyFinder;
    private final ExerciseSafetyContraindicationFinder exerciseSafetyContraindicationFinder;
    private final ExerciseInstructionFinder exerciseInstructionFinder;
    private final ExerciseMovementPatternFinder exerciseMovementPatternFinder;
    private final ExerciseEnvironmentFinder exerciseEnvironmentFinder;
    private final ExerciseVariantFinder exerciseVariantFinder;

    public ExerciseDetailDto findDetailById(UUID exerciseId) {
        return ExerciseDetailDto.builderDetail()
                .withBaseExercise(this.exerciseFinder.findById(exerciseId))
                .withEnvironment(this.exerciseEnvironmentFinder.findExerciseEnvironment(exerciseId))
                .withMovementPattern(this.exerciseMovementPatternFinder.findExerciseMovementPattern(exerciseId))
                .withInstructions(this.exerciseInstructionFinder.findExerciseInstructions(exerciseId))
                .withVariants(this.exerciseVariantFinder.findExerciseVariants(exerciseId))
                .withMedia(this.exerciseMediaFinder.findExerciseMedia(exerciseId))
                .withSafety(this.exerciseSafetyFinder.findExerciseSafetyNotes(exerciseId))
                .withSafetyContraindications(this.exerciseSafetyContraindicationFinder.findExerciseSafetyContraindicationNotes(exerciseId))
                .withCategories(this.exerciseCategoryFinder.findExerciseCategory(exerciseId))
                .withMuscles(this.exerciseMuscleFinder.findExerciseMuscles(exerciseId))
                .withEquipments(this.exerciseEquipmentFinder.findExerciseEquipments(exerciseId))
                .withTags(this.exerciseTagFinder.findExerciseTags(exerciseId))
                .build();
    }
}
