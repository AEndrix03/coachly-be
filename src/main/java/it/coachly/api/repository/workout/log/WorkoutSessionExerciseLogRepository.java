package it.coachly.api.repository.workout.log;

import it.coachly.api.model.workout.log.WorkoutSessionExerciseLog;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface WorkoutSessionExerciseLogRepository extends JpaRepository<WorkoutSessionExerciseLog, UUID>, QuerydslPredicateExecutor<WorkoutSessionExerciseLog> {
}
