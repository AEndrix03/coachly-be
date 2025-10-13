package it.coachly.api.service.exercise.finder.component.core;

import com.querydsl.jpa.impl.JPAQueryFactory;
import it.coachly.api.model.exercise.core.QExerciseInstruction;
import it.coachly.api.service.exercise.data.component.core.ExerciseInstructionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ExerciseInstructionFinder {
    private final JPAQueryFactory qu;

    public List<ExerciseInstructionDto> findExerciseInstructions(UUID exerciseId) {
        QExerciseInstruction qEI = QExerciseInstruction.exerciseInstruction;
        return qu.select(ExerciseInstructionDto.getProjection())
                .from(qEI)
                .where(qEI.exerciseId.eq(exerciseId))
                .fetch();
    }
}
