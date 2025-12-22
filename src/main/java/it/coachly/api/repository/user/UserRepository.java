package it.coachly.api.repository.user;

import it.coachly.api.model.user.User;
import it.coachly.api.model.user.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserRepository extends JpaRepository<User, UserId>, QuerydslPredicateExecutor<User> {
}
