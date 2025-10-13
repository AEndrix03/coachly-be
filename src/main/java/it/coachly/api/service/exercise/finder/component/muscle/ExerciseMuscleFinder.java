package it.coachly.api.service.exercise.finder.component.muscle;

import com.querydsl.jpa.impl.JPAQueryFactory;
import it.coachly.api.model.muscle.exercise.QExerciseMuscle;
import it.coachly.api.service.exercise.data.component.muscle.ExerciseMuscleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ExerciseMuscleFinder {
    private final JPAQueryFactory qu;

    public List<ExerciseMuscleDto> findExerciseMuscles(UUID exerciseId) {
        QExerciseMuscle qEM = QExerciseMuscle.exerciseMuscle;
        return qu.select(ExerciseMuscleDto.getProjection())
                .from(qEM)
                .where(qEM.exerciseId.eq(exerciseId))
                .fetch();
    }
}
