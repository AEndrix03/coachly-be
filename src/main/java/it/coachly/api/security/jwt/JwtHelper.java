package it.coachly.api.security.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
public class JwtHelper {

    public Jwt getJwt() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof Jwt jwt) {
            return jwt;
        }
        throw new RuntimeException("JWT non trovato nel contesto di sicurezza");
    }

    public String getUserId() {
        return getJwt().getSubject();
    }

    public String getUserId(Jwt jwt) {
        return jwt.getSubject();
    }

    public URL getIssuer() {
        return getJwt().getClaim("iss");
    }

    public URL getIssuer(Jwt jwt) {
        return jwt.getClaim("iss");
    }

    public String getClaim(String claimName) {
        return getJwt().getClaim(claimName);
    }

    public <T> T getClaim(String claimName, Class<T> type) {
        return this.getClaim(this.getJwt(), claimName, type);
    }

    public <T> T getClaim(Jwt jwt, String claimName, Class<T> type) {
        return jwt.getClaim(claimName);
    }
}