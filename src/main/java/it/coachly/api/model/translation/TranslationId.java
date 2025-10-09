package it.coachly.api.model.translation;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Embeddable
public class TranslationId implements Serializable {
    private static final long serialVersionUID = 1676765471526440821L;
    @Size(max = 50)
    @NotNull
    @Column(name = "entity_type", nullable = false, length = 50)
    private String entityType;

    @NotNull
    @Column(name = "entity_id", nullable = false)
    private UUID entityId;

    @Size(max = 10)
    @NotNull
    @Column(name = "locale", nullable = false, length = 10)
    private String locale;

    @Size(max = 100)
    @NotNull
    @Column(name = "field_name", nullable = false, length = 100)
    private String fieldName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TranslationId entity = (TranslationId) o;
        return Objects.equals(this.fieldName, entity.fieldName) &&
                Objects.equals(this.entityType, entity.entityType) &&
                Objects.equals(this.entityId, entity.entityId) &&
                Objects.equals(this.locale, entity.locale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldName, entityType, entityId, locale);
    }

}