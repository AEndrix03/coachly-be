package it.coachly.api.repository.workout;

import it.coachly.api.model.workout.WorkoutPlanShare;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface WorkoutPlanShareRepository extends JpaRepository<WorkoutPlanShare, UUID>, QuerydslPredicateExecutor<WorkoutPlanShare> {
}
