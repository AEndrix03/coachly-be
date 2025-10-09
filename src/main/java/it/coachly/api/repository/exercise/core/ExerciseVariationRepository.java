package it.coachly.api.repository.exercise.core;

import it.coachly.api.model.exercise.core.ExerciseVariation;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ExerciseVariationRepository extends JpaRepository<ExerciseVariation, UUID>, QuerydslPredicateExecutor<ExerciseVariation> {
}
