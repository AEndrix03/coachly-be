package it.coachly.api.repository.exercise.core;

import it.coachly.api.model.exercise.core.Exercise;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ExerciseRepository extends JpaRepository<Exercise, UUID>, QuerydslPredicateExecutor<Exercise> {
}
