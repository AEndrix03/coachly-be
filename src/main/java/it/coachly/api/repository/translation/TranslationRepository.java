package it.coachly.api.repository.translation;

import it.coachly.api.model.translation.Translation;
import it.coachly.api.model.translation.TranslationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TranslationRepository extends JpaRepository<Translation, TranslationId>, QuerydslPredicateExecutor<Translation> {
}
