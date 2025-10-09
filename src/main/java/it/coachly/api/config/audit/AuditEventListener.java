package it.coachly.api.config;

import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.Instant;
import java.util.UUID;

/**
 * Listener Hibernate globale
 */
public class AuditEventListener implements PreInsertEventListener, PreUpdateEventListener {

    @Override
    public boolean onPreInsert(PreInsertEvent event) {
        Object entity = event.getEntity();
        Object[] state = event.getState();
        String[] properties = event.getPersister().getPropertyNames();

        setProperty(state, properties, "createdAt", Instant.now());
        setProperty(state, properties, "updatedAt", Instant.now());

        UUID currentUser = getCurrentUser();
        if (currentUser != null) {
            setProperty(state, properties, "createdBy", currentUser);
        }

        return false;
    }

    @Override
    public boolean onPreUpdate(PreUpdateEvent event) {
        Object[] state = event.getState();
        String[] properties = event.getPersister().getPropertyNames();

        setProperty(state, properties, "updatedAt", Instant.now());

        UUID currentUser = getCurrentUser();
        if (currentUser != null) {
            setProperty(state, properties, "updatedBy", currentUser);
        }

        return false;
    }

    private void setProperty(Object[] state, String[] properties, String propertyName, Object value) {
        for (int i = 0; i < properties.length; i++) {
            if (properties[i].equals(propertyName)) {
                state[i] = value;
                return;
            }
        }
    }

    private UUID getCurrentUser() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getPrincipal())) {
                Object principal = auth.getPrincipal();
                if (principal instanceof UUID) {
                    return (UUID) principal;
                }
                //TODO: Adatta qui al sistema auth
            }
        } catch (Exception e) {
            // Ignora
        }
        return null;
    }
}