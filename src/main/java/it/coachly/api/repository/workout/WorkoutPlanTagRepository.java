package it.coachly.api.repository.workout;

import it.coachly.api.model.workout.WorkoutPlanTag;
import it.coachly.api.model.workout.WorkoutPlanTagId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface WorkoutPlanTagRepository extends JpaRepository<WorkoutPlanTag, WorkoutPlanTagId>, QuerydslPredicateExecutor<WorkoutPlanTag> {
}
