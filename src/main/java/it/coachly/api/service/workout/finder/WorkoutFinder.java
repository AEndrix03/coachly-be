package it.coachly.api.service.workout.finder;

import com.querydsl.jpa.impl.JPAQueryFactory;
import it.coachly.api.model.workout.QWorkoutPlan;
import it.coachly.api.service.workout.data.WorkoutDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class WorkoutFinder {

    private final JPAQueryFactory qu;

    public List<WorkoutDto> findAllUserWorkouts(UUID userId) {
        QWorkoutPlan qWP = QWorkoutPlan.workoutPlan;
        return qu.select(WorkoutDto.getProjection())
                .from(qWP)
                .where(qWP.createdByUserId.eq(userId), qWP.isActive.isTrue())
                .fetch();
    }

}
