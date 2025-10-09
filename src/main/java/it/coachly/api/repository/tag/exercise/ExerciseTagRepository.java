package it.coachly.api.repository.tag.exercise;

import it.coachly.api.model.tag.exercise.ExerciseTag;
import it.coachly.api.model.tag.exercise.ExerciseTagId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ExerciseTagRepository extends JpaRepository<ExerciseTag, ExerciseTagId>, QuerydslPredicateExecutor<ExerciseTag> {
}
