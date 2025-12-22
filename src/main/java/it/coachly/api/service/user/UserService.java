package it.coachly.api.service.user;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public interface UserService {

    UUID getUserIdByExternalIdAndAuthProvider(@NotNull String externalId, @NotNull String authProvider);

    UUID getUserIdByUsername(@NotNull String username);
}
