package it.coachly.api.repository.workout;

import it.coachly.api.model.workout.WorkoutPlan;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, UUID>, QuerydslPredicateExecutor<WorkoutPlan> {
}
