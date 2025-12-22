package it.coachly.api.repository.workout;

import it.coachly.api.model.workout.WorkoutPlanWeek;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface WorkoutPlanWeekRepository extends JpaRepository<WorkoutPlanWeek, UUID>, QuerydslPredicateExecutor<WorkoutPlanWeek> {
}
