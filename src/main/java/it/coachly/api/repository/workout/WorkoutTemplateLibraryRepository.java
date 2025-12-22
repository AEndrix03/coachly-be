package it.coachly.api.repository.workout;

import it.coachly.api.model.workout.WorkoutTemplateLibrary;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface WorkoutTemplateLibraryRepository extends JpaRepository<WorkoutTemplateLibrary, UUID>, QuerydslPredicateExecutor<WorkoutTemplateLibrary> {
}
