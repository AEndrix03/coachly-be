package it.coachly.api.service.exercise.finder.component.core;

import com.querydsl.jpa.impl.JPAQueryFactory;
import it.coachly.api.model.exercise.core.QExerciseVariation;
import it.coachly.api.service.exercise.data.component.core.ExerciseVariantDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ExerciseVariantFinder {
    private final JPAQueryFactory qu;

    public List<ExerciseVariantDto> findExerciseVariants(UUID exerciseId) {
        QExerciseVariation qEV = QExerciseVariation.exerciseVariation;
        return qu.select(ExerciseVariantDto.getVariatProjection())
                .from(qEV)
                .where(qEV.baseExercise.id.eq(exerciseId))
                .fetch();
    }
}
