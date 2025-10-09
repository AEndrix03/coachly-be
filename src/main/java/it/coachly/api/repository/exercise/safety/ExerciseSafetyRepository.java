package it.coachly.api.repository.exercise.safety;

import it.coachly.api.model.exercise.safety.ExerciseSafety;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ExerciseSafetyRepository extends JpaRepository<ExerciseSafety, UUID>, QuerydslPredicateExecutor<ExerciseSafety> {
}
