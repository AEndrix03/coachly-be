package it.coachly.api.repository.workout.log;

import it.coachly.api.model.workout.log.WorkoutSessionCardioLog;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface WorkoutSessionCardioLogRepository extends JpaRepository<WorkoutSessionCardioLog, UUID>, QuerydslPredicateExecutor<WorkoutSessionCardioLog> {
}
