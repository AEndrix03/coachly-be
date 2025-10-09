package it.coachly.api.repository.muscle.exercise;

import it.coachly.api.model.muscle.exercise.ExerciseMuscle;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ExerciseMuscleRepository extends JpaRepository<ExerciseMuscle, UUID>, QuerydslPredicateExecutor<ExerciseMuscle> {
}
