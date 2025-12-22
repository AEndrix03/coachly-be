package it.coachly.api.repository.workout;

import it.coachly.api.model.workout.WorkoutPlanDay;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface WorkoutPlanDayRepository extends JpaRepository<WorkoutPlanDay, UUID>, QuerydslPredicateExecutor<WorkoutPlanDay> {
}
