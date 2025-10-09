package it.coachly.api.repository.muscle;

import it.coachly.api.model.muscle.ContractionType;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ContractionTypeRepository extends JpaRepository<ContractionType, UUID>, QuerydslPredicateExecutor<ContractionType> {
}
