package it.coachly.api.service.exercise.finder.component.safety;

import com.querydsl.jpa.impl.JPAQueryFactory;
import it.coachly.api.model.exercise.safety.QExerciseSafetyContraindication;
import it.coachly.api.service.exercise.data.component.safety.ExerciseSafetyContraindicationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ExerciseSafetyContraindicationFinder {
    private final JPAQueryFactory qu;

    public List<ExerciseSafetyContraindicationDto> findExerciseSafetyContraindicationNotes(UUID exerciseId) {
        QExerciseSafetyContraindication qESD = QExerciseSafetyContraindication.exerciseSafetyContraindication;
        return qu.select(ExerciseSafetyContraindicationDto.getProjection())
                .from(qESD)
                .where(qESD.exerciseId.eq(exerciseId))
                .fetch();
    }
}
