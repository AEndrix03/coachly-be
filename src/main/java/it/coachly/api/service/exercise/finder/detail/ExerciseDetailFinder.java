package it.coachly.api.service.exercise.finder.detail;

import com.querydsl.jpa.impl.JPAQueryFactory;
import it.coachly.api.model.equipment.QEquipment;
import it.coachly.api.model.equipment.equipment.QExerciseEquipment;
import it.coachly.api.model.exercise.core.*;
import it.coachly.api.model.exercise.media.QExerciseMedia;
import it.coachly.api.model.exercise.safety.QExerciseSafety;
import it.coachly.api.model.exercise.safety.QExerciseSafetyContraindication;
import it.coachly.api.model.muscle.QMuscle;
import it.coachly.api.model.muscle.exercise.QExerciseMuscle;
import it.coachly.api.model.tag.QTag;
import it.coachly.api.model.tag.exercise.QExerciseTag;
import it.coachly.api.service.exercise.data.component.core.ExerciseEnvironmentDto;
import it.coachly.api.service.exercise.data.component.core.ExerciseInstructionDto;
import it.coachly.api.service.exercise.data.component.core.ExerciseMovementPatternDto;
import it.coachly.api.service.exercise.data.component.core.ExerciseVariantDto;
import it.coachly.api.service.exercise.data.component.equipment.ExerciseEquipmentDto;
import it.coachly.api.service.exercise.data.component.media.ExerciseMediaDto;
import it.coachly.api.service.exercise.data.component.muscle.ExerciseMuscleDto;
import it.coachly.api.service.exercise.data.component.safety.ExerciseSafetyContraindicationDto;
import it.coachly.api.service.exercise.data.component.safety.ExerciseSafetyDto;
import it.coachly.api.service.exercise.data.detail.ExerciseDetailDto;
import it.coachly.api.service.exercise.finder.component.category.ExerciseCategoryFinder;
import it.coachly.api.service.tag.data.TagDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ExerciseDetailFinder {

    private final JPAQueryFactory qu;
    private final ExerciseCategoryFinder exerciseCategoryFinder;

    public ExerciseDetailDto findDetailById(UUID exerciseId) {
        QExercise qE = QExercise.exercise;
        return ExerciseDetailDto.builderDetail()
                .withBaseExercise(
                        this.qu.select(ExerciseDetailDto.getProjection())
                                .from(qE)
                                .where(qE.id.eq(exerciseId))
                                .fetchOne())
                .withEnvironment(this.findExerciseEnvironment(exerciseId))
                .withMovementPattern(this.findExerciseMovementPattern(exerciseId))
                .withInstructions(this.findExerciseInstructions(exerciseId))
                .withVariants(this.findExerciseVariants(exerciseId))
                .withMedia(this.findExerciseMedia(exerciseId))
                .withSafety(this.findExerciseSafetyNotes(exerciseId))
                .withSafetyContraindications(this.findExerciseSafetyContraindicationNotes(exerciseId))
                .withCategories(this.exerciseCategoryFinder.findExerciseCategory(exerciseId))
                .withMuscles(this.findExerciseMuscles(exerciseId))
                .withEquipments(this.findExerciseEquipments(exerciseId))
                .withTags(this.findExerciseTags(exerciseId))
                .build();
    }

    public ExerciseEnvironmentDto findExerciseEnvironment(UUID exerciseId) {
        QExercise qE = QExercise.exercise;
        QExerciseEnvironment qEE = QExerciseEnvironment.exerciseEnvironment;
        return this.qu.select(ExerciseEnvironmentDto.getProjection())
                .innerJoin(qEE).on(qEE.exercises.id.eq(qE.id))
                .from(qEE)
                .where(qE.id.eq(exerciseId))
                .fetchOne();
    }

    public ExerciseMovementPatternDto findExerciseMovementPattern(UUID exerciseId) {
        QExercise qE = QExercise.exercise;
        QExerciseMovementPattern qEMP = QExerciseMovementPattern.exerciseMovementPattern;
        return this.qu.select(ExerciseMovementPatternDto.getProjection())
                .innerJoin(qEMP).on(qEMP.exercises.id.eq(qE.id))
                .from(qEMP)
                .where(qE.id.eq(exerciseId))
                .fetchOne();
    }

    public List<ExerciseInstructionDto> findExerciseInstructions(UUID exerciseId) {
        QExercise qE = QExercise.exercise;
        QExerciseInstruction qEI = QExerciseInstruction.exerciseInstruction;
        return this.qu.select(ExerciseInstructionDto.getProjection())
                .innerJoin(qEI).on(qEI.exercise.id.eq(qE.id))
                .from(qEI)
                .where(qE.id.eq(exerciseId))
                .orderBy(qEI.stepNumber.asc())
                .fetch();
    }

    public List<ExerciseVariantDto> findExerciseVariants(UUID exerciseId) {
        QExercise qE = QExercise.exercise;
        QExerciseVariation qEV = QExerciseVariation.exerciseVariation;
        return this.qu.select(ExerciseVariantDto.getVariatProjection())
                .innerJoin(qEV).on(qEV.baseExercise.id.eq(qE.id))
                .from(qEV)
                .where(qE.id.eq(exerciseId))
                .fetch();
    }

    public List<ExerciseMediaDto> findExerciseMedia(UUID exerciseId) {
        QExercise qE = QExercise.exercise;
        QExerciseMedia qEM = QExerciseMedia.exerciseMedia;
        return this.qu.select(ExerciseMediaDto.getProjection())
                .innerJoin(qEM).on(qEM.exercise.id.eq(qE.id))
                .from(qEM)
                .where(qE.id.eq(exerciseId))
                .fetch();
    }

    public List<ExerciseSafetyDto> findExerciseSafetyNotes(UUID exerciseId) {
        QExercise qE = QExercise.exercise;
        QExerciseSafety qES = QExerciseSafety.exerciseSafety;
        return this.qu.select(ExerciseSafetyDto.getProjection())
                .innerJoin(qES).on(qES.exercises.id.eq(qE.id))
                .from(qES)
                .where(qE.id.eq(exerciseId))
                .fetch();
    }

    public List<ExerciseSafetyContraindicationDto> findExerciseSafetyContraindicationNotes(UUID exerciseId) {
        QExercise qE = QExercise.exercise;
        QExerciseSafetyContraindication qESC = QExerciseSafetyContraindication.exerciseSafetyContraindication;
        return this.qu.select(ExerciseSafetyContraindicationDto.getProjection())
                .innerJoin(qESC).on(qESC.exercise.id.eq(qE.id))
                .from(qESC)
                .where(qE.id.eq(exerciseId))
                .fetch();
    }

    public List<ExerciseMuscleDto> findExerciseMuscles(UUID exerciseId) {
        QExercise qE = QExercise.exercise;
        QMuscle qM = QMuscle.muscle;
        QExerciseMuscle qEM = QExerciseMuscle.exerciseMuscle;
        return this.qu.select(ExerciseMuscleDto.getProjection())
                .innerJoin(qEM).on(qEM.exercise.id.eq(qE.id))
                .innerJoin(qM).on(qM.id.eq(qEM.muscle.id))
                .from(qE)
                .where(qE.id.eq(exerciseId))
                .fetch();
    }

    public List<ExerciseEquipmentDto> findExerciseEquipments(UUID exerciseId) {
        QExercise qE = QExercise.exercise;
        QEquipment qEq = QEquipment.equipment;
        QExerciseEquipment qEE = QExerciseEquipment.exerciseEquipment;
        return this.qu.select(ExerciseEquipmentDto.getProjection())
                .innerJoin(qEE).on(qEE.exercise.id.eq(qE.id))
                .innerJoin(qEq).on(qEq.id.eq(qEE.equipment.id))
                .from(qE)
                .where(qE.id.eq(exerciseId))
                .fetch();
    }

    public List<TagDto> findExerciseTags(UUID exerciseId) {
        QExercise qE = QExercise.exercise;
        QTag qT = QTag.tag;
        QExerciseTag qET = QExerciseTag.exerciseTag;
        return this.qu.select(TagDto.getProjection())
                .innerJoin(qET).on(qE.id.eq(qET.exercise.id))
                .innerJoin(qT).on(qT.id.eq(qET.tag.id))
                .from(qE)
                .where(qE.id.eq(exerciseId))
                .fetch();
    }
}
