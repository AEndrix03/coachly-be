package it.coachly.api.repository.exercise.safety;

import it.coachly.api.model.exercise.safety.ExerciseSafetyContraindication;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ExerciseSafetyContraindicationRepository extends JpaRepository<ExerciseSafetyContraindication, UUID>, QuerydslPredicateExecutor<ExerciseSafetyContraindication> {
}
