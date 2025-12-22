package it.coachly.api.repository.user;

import it.coachly.api.model.user.UserInfo;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserInfoRepository extends JpaRepository<UserInfo, UUID>, QuerydslPredicateExecutor<UserInfo> {
}
