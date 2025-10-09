package it.coachly.api.repository.muscle;

import it.coachly.api.model.muscle.Muscle;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MuscleRepository extends JpaRepository<Muscle, UUID>, QuerydslPredicateExecutor<Muscle> {
}
