package it.coachly.api.repository.workout.exercise;

import it.coachly.api.model.workout.exercise.WorkoutExerciseGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;
import java.util.UUID;

public interface WorkoutExerciseGroupRepository extends JpaRepository<WorkoutExerciseGroup, UUID>, QuerydslPredicateExecutor<WorkoutExerciseGroup> {

    List<WorkoutExerciseGroup> findAllByWorkoutPlan_Id(UUID workoutPlanId);

}
