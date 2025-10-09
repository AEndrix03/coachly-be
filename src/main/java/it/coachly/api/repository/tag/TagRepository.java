package it.coachly.api.repository.tag;

import it.coachly.api.model.tag.Tag;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TagRepository extends JpaRepository<Tag, UUID>, QuerydslPredicateExecutor<Tag> {
}
