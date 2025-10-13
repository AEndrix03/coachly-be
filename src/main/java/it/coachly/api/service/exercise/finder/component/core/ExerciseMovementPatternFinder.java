package it.coachly.api.service.exercise.finder.component.core;

import com.querydsl.jpa.impl.JPAQueryFactory;
import it.coachly.api.model.exercise.core.QExerciseMovementPattern;
import it.coachly.api.service.exercise.data.component.core.ExerciseMovementPatternDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ExerciseMovementPatternFinder {
    private final JPAQueryFactory qu;

    public ExerciseMovementPatternDto findExerciseMovementPattern(UUID exerciseId) {
        QExerciseMovementPattern qEMP = QExerciseMovementPattern.exerciseMovementPattern;
        return qu.select(ExerciseMovementPatternDto.getProjection())
                .from(qEMP)
                .where(qEMP.exerciseId.eq(exerciseId))
                .fetchOne();
    }
}
