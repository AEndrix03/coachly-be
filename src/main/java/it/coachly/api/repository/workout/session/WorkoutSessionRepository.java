package it.coachly.api.repository.workout.session;

import it.coachly.api.model.workout.session.WorkoutSession;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface WorkoutSessionRepository extends JpaRepository<WorkoutSession, UUID>, QuerydslPredicateExecutor<WorkoutSession> {
}
