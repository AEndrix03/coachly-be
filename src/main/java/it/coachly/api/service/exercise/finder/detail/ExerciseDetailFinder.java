package it.coachly.api.service.exercise.finder.detail;

import com.querydsl.jpa.impl.JPAQueryFactory;
import it.coachly.api.model.exercise.core.*;
import it.coachly.api.model.exercise.media.QExerciseMedia;
import it.coachly.api.model.exercise.safety.QExerciseSafety;
import it.coachly.api.model.exercise.safety.QExerciseSafetyContraindication;
import it.coachly.api.service.exercise.data.core.ExerciseEnvironmentDto;
import it.coachly.api.service.exercise.data.core.ExerciseInstructionDto;
import it.coachly.api.service.exercise.data.core.ExerciseMovementPatternDto;
import it.coachly.api.service.exercise.data.core.ExerciseVariantDto;
import it.coachly.api.service.exercise.data.detail.ExerciseDetailDto;
import it.coachly.api.service.exercise.data.media.ExerciseMediaDto;
import it.coachly.api.service.exercise.data.safety.ExerciseSafetyContraindicationDto;
import it.coachly.api.service.exercise.data.safety.ExerciseSafetyDto;
import it.coachly.api.service.exercise.finder.category.ExerciseCategoryFinder;
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
                .build();
    }

    public ExerciseEnvironmentDto findExerciseEnvironment(UUID exerciseId) {
        QExercise qE = QExercise.exercise;
        QExerciseEnvironment qEE = QExerciseEnvironment.exerciseEnvironment;
        return this.qu.select(ExerciseEnvironmentDto.getProjection())
                .innerJoin(qEE).on(qEE.exercises.id.eq(qE.id))
                .from(qEE)
                .fetchOne();
    }

    public ExerciseMovementPatternDto findExerciseMovementPattern(UUID exerciseId) {
        QExercise qE = QExercise.exercise;
        QExerciseMovementPattern qEMP = QExerciseMovementPattern.exerciseMovementPattern;
        return this.qu.select(ExerciseMovementPatternDto.getProjection())
                .innerJoin(qEMP).on(qEMP.exercises.id.eq(qE.id))
                .from(qEMP)
                .fetchOne();
    }

    public List<ExerciseInstructionDto> findExerciseInstructions(UUID exerciseId) {
        QExercise qE = QExercise.exercise;
        QExerciseInstruction qEI = QExerciseInstruction.exerciseInstruction;
        return this.qu.select(ExerciseInstructionDto.getProjection())
                .innerJoin(qEI).on(qEI.exercise.id.eq(qE.id))
                .from(qEI)
                .fetch();
    }

    public List<ExerciseVariantDto> findExerciseVariants(UUID exerciseId) {
        QExercise qE = QExercise.exercise;
        QExerciseVariation qEV = QExerciseVariation.exerciseVariation;
        return this.qu.select(ExerciseVariantDto.getVariatProjection())
                .innerJoin(qEV).on(qEV.baseExercise.id.eq(qE.id))
                .from(qEV)
                .fetch();
    }

    public List<ExerciseMediaDto> findExerciseMedia(UUID exerciseId) {
        QExercise qE = QExercise.exercise;
        QExerciseMedia qEM = QExerciseMedia.exerciseMedia;
        return this.qu.select(ExerciseMediaDto.getProjection())
                .innerJoin(qEM).on(qEM.exercise.id.eq(qE.id))
                .from(qEM)
                .fetch();
    }

    public List<ExerciseSafetyDto> findExerciseSafetyNotes(UUID exerciseId) {
        QExercise qE = QExercise.exercise;
        QExerciseSafety qES = QExerciseSafety.exerciseSafety;
        return this.qu.select(ExerciseSafetyDto.getProjection())
                .innerJoin(qES).on(qES.exercises.id.eq(qE.id))
                .from(qES)
                .fetch();
    }

    public List<ExerciseSafetyContraindicationDto> findExerciseSafetyContraindicationNotes(UUID exerciseId) {
        QExercise qE = QExercise.exercise;
        QExerciseSafetyContraindication qESC = QExerciseSafetyContraindication.exerciseSafetyContraindication;
        return this.qu.select(ExerciseSafetyContraindicationDto.getProjection())
                .innerJoin(qESC).on(qESC.exercise.id.eq(qE.id))
                .from(qESC)
                .fetch();
    }

}
