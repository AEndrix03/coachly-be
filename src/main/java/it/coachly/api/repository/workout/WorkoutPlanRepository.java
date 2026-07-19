package it.coachly.api.repository.workout;

import it.coachly.api.model.workout.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, UUID>, QuerydslPredicateExecutor<WorkoutPlan> {

    List<WorkoutPlan> findAllByCreatedByUserId(UUID createdByUserId);

    Optional<WorkoutPlan> findByIdAndCreatedByUserId(UUID id, UUID createdByUserId);

}
