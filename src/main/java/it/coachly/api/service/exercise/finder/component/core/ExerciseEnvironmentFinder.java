package it.coachly.api.service.exercise.finder.component.core;

import com.querydsl.jpa.impl.JPAQueryFactory;
import it.coachly.api.model.exercise.core.QExerciseEnvironment;
import it.coachly.api.service.exercise.data.component.core.ExerciseEnvironmentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ExerciseEnvironmentFinder {
    private final JPAQueryFactory qu;

    public ExerciseEnvironmentDto findExerciseEnvironment(UUID exerciseId) {
        QExerciseEnvironment qEE = QExerciseEnvironment.exerciseEnvironment;
        return qu.select(ExerciseEnvironmentDto.getProjection())
                .from(qEE)
                .where(qEE.id.eq(exerciseId))
                .fetchOne();
    }
}
