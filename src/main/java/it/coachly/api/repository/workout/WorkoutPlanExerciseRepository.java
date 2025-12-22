package it.coachly.api.repository.workout;

import it.coachly.api.model.workout.WorkoutPlanExercise;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface WorkoutPlanExerciseRepository extends JpaRepository<WorkoutPlanExercise, UUID>, QuerydslPredicateExecutor<WorkoutPlanExercise> {
}
