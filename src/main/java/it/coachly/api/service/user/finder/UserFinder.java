package it.coachly.api.service.user.finder;


import com.querydsl.jpa.impl.JPAQueryFactory;
import it.coachly.api.model.user.QAuthenticator;
import it.coachly.api.model.user.QUser;
import it.coachly.api.model.user.QUserInfo;
import it.coachly.api.model.user.User;
import it.coachly.api.service.user.data.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFinder {

    private final JPAQueryFactory qu;

    public UserDto findUserDtoByExternalIdAndAuthProvider(String externalId, String authProvider) {
        QUser qUser = QUser.user;
        QAuthenticator qA = QAuthenticator.authenticator;
        return this.qu.query()
                .select(UserDto.getProjection())
                .from(qUser)
                .join(qA).on(qA.name.toUpperCase().eq(authProvider.toUpperCase()))
                .where(qUser.id.externalId.eq(externalId), qUser.id.authenticatorId.eq(qA.id))
                .fetchOne();
    }

    public User findUserByExternalIdAndAuthProvider(String externalId, String authProvider) {
        QUser qUser = QUser.user;
        QAuthenticator qA = QAuthenticator.authenticator;
        return this.qu.query()
                .select(qUser)
                .from(qUser)
                .join(qA).on(qA.name.toUpperCase().eq(authProvider.toUpperCase()))
                .where(qUser.id.externalId.eq(externalId), qUser.id.authenticatorId.eq(qA.id))
                .fetchOne();
    }

    public User findUserByUsername(String username) {
        QUser qUser = QUser.user;
        QUserInfo qUI = QUserInfo.userInfo;
        return this.qu.query()
                .select(qUser)
                .from(qUser)
                .join(qUI).on(qUI.userId.eq(qUser.id.id))
                .where(qUI.username.toUpperCase().eq(username.toUpperCase()))
                .fetchOne();
    }

}
