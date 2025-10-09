package it.coachly.api.repository.exercise.core;

import it.coachly.api.model.exercise.core.ExerciseMovementPattern;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ExerciseMovementPatternRepository extends JpaRepository<ExerciseMovementPattern, UUID>, QuerydslPredicateExecutor<ExerciseMovementPattern> {
}
