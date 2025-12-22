package it.coachly.api.repository.workout;

import it.coachly.api.model.workout.WorkoutPlanMetric;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface WorkoutPlanMetricRepository extends JpaRepository<WorkoutPlanMetric, UUID>, QuerydslPredicateExecutor<WorkoutPlanMetric> {
}
