package it.coachly.api.service.exercise.finder.component.safety;

import com.querydsl.jpa.impl.JPAQueryFactory;
import it.coachly.api.model.exercise.safety.QExerciseSafety;
import it.coachly.api.service.exercise.data.component.safety.ExerciseSafetyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ExerciseSafetyFinder {
    private final JPAQueryFactory qu;

    public List<ExerciseSafetyDto> findExerciseSafetyNotes(UUID exerciseId) {
        QExerciseSafety qES = QExerciseSafety.exerciseSafety;
        return qu.select(ExerciseSafetyDto.getProjection())
                .from(qES)
                .where(qES.exerciseId.eq(exerciseId))
                .fetch();
    }
}
