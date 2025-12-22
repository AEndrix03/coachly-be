package it.coachly.api.repository.user;

import it.coachly.api.model.user.Authenticator;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AuthenticatorRepository extends JpaRepository<Authenticator, UUID>, QuerydslPredicateExecutor<Authenticator> {
}
