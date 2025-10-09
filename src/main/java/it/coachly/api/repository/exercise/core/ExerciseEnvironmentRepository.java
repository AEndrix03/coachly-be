package it.coachly.api.repository.exercise.core;

import it.coachly.api.model.exercise.core.ExerciseEnvironment;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ExerciseEnvironmentRepository extends JpaRepository<ExerciseEnvironment, UUID>, QuerydslPredicateExecutor<ExerciseEnvironment> {
}
