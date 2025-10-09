package it.coachly.api.repository.exercise.category;

import it.coachly.api.model.exercise.category.ExerciseCategoryMapping;
import it.coachly.api.model.exercise.category.ExerciseCategoryMappingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ExerciseCategoryMappingRepository extends JpaRepository<ExerciseCategoryMapping, ExerciseCategoryMappingId>, QuerydslPredicateExecutor<ExerciseCategoryMapping> {
}
