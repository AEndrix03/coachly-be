package it.coachly.api.repository.exercise.metrics;

import it.coachly.api.model.exercise.metrics.ExerciseMetric;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ExerciseMetricRepository extends JpaRepository<ExerciseMetric, UUID>, QuerydslPredicateExecutor<ExerciseMetric> {
}
