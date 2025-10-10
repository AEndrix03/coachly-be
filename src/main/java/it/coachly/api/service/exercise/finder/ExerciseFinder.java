package it.coachly.api.service.exercise.finder;

import com.querydsl.jpa.impl.JPAQueryFactory;
import it.coachly.api.model.exercise.core.QExercise;
import it.coachly.api.service.exercise.data.ExerciseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ExerciseFinder {

    private final JPAQueryFactory qu;

    public ExerciseDto findById(UUID id) {
        QExercise qE = QExercise.exercise;
        return this.qu.select(ExerciseDto.getProjection())
                .from(qE)
                .where(qE.id.eq(id))
                .fetchOne();
    }

}
