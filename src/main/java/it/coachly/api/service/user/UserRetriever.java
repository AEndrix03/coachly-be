package it.coachly.api.service.user;

import it.coachly.api.security.jwt.JwtHelper;
import it.coachly.api.service.user.data.UserDto;
import it.coachly.api.service.user.finder.UserFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRetriever {

    private final UserFinder userFinder;
    private final JwtHelper jwtHelper;

    public UserDto retrieve() {
        var token = this.jwtHelper.getJwt();

        var externalId = this.jwtHelper.getUserId(token);
        var authProvider = this.jwtHelper.getIssuer();

        if (authProvider.equalsIgnoreCase("dominatus-backend")) {
            authProvider = "DOMINATUS";
        }

        var user = this.userFinder.findUserDtoByExternalIdAndAuthProvider(externalId, authProvider);

        if (user == null) {
            throw new IllegalArgumentException("User not found for externalId: " + externalId + " and authProvider: " + authProvider);
        }

        return user;
    }

}
