package it.coachly.api.controller.user;

import it.coachly.api.service.user.UserService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public UUID getUserIdByExternalIdAndAuthProvider(@RequestParam @NotNull String externalId,
                                                     @RequestParam @NotNull String authProvider) {
        log.debug("getUserIdByExternalIdAndAuthProvider for external id: {}, and provider: {}", externalId, authProvider);
        return this.userService.getUserIdByExternalIdAndAuthProvider(externalId, authProvider);
    }

    @GetMapping("/username")
    public UUID getUserIdByUsername(@RequestParam @NotNull String username) {
        log.debug("get User Id for username: {}", username);
        return this.userService.getUserIdByUsername(username);
    }

}
