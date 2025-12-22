package it.coachly.api.service.user;

import it.coachly.api.service.user.finder.UserFinder;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserFinder userFinder;

    @Override
    public UUID getUserIdByExternalIdAndAuthProvider(@NotNull String externalId, @NotNull String authProvider) {
        var user = this.userFinder.findUserByExternalIdAndAuthProvider(externalId, authProvider);

        if (user == null) {
            throw new IllegalArgumentException("User not found for externalId: " + externalId + " and authProvider: " + authProvider);
        }

        return user.getId().getId();
    }

    @Override
    public UUID getUserIdByUsername(@NotNull String username) {
        var user = this.userFinder.findUserByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User not found for username: " + username);
        }

        return user.getId().getId();
    }

}
