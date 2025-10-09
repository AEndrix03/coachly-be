package it.coachly.api.repository.exercise.category;

import it.coachly.api.model.exercise.category.ExerciseCategory;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ExerciseCategoryRepository extends JpaRepository<ExerciseCategory, UUID>, QuerydslPredicateExecutor<ExerciseCategory> {
}
