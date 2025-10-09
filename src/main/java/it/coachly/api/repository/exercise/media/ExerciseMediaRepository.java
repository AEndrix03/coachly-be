package it.coachly.api.repository.exercise.media;

import it.coachly.api.model.exercise.media.ExerciseMedia;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ExerciseMediaRepository extends JpaRepository<ExerciseMedia, UUID>, QuerydslPredicateExecutor<ExerciseMedia> {
}
