package it.coachly.api.repository.workout.exercise;

import it.coachly.api.model.workout.exercise.WorkoutExerciseAlternative;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface WorkoutExerciseAlternativeRepository extends JpaRepository<WorkoutExerciseAlternative, UUID>, QuerydslPredicateExecutor<WorkoutExerciseAlternative> {
}
