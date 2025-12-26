package it.coachly.api.repository.workout.exercise;

import it.coachly.api.model.workout.WorkoutPlanExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;
import java.util.UUID;

public interface WorkoutPlanExerciseRepository extends JpaRepository<WorkoutPlanExercise, UUID>, QuerydslPredicateExecutor<WorkoutPlanExercise> {

    List<WorkoutPlanExercise> findAllByWorkoutExerciseGroup_Id(UUID workoutExerciseGroupId);

}
