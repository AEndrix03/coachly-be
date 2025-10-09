package it.coachly.api.exception;

import it.coachly.api.enums.translation.LocaleEnum;
import lombok.Getter;

import java.util.UUID;

@Getter
public class TranslationNotFoundException extends RuntimeException {

    private final String entityType;
    private final UUID entityId;
    private final LocaleEnum locale;
    private final String fieldName;

    public TranslationNotFoundException(String entityType, UUID entityId, LocaleEnum locale, String fieldName) {
        super(String.format("Translation not found for entity '%s' with id '%s', locale '%s', field '%s'",
                entityType, entityId, locale, fieldName));
        this.entityType = entityType;
        this.entityId = entityId;
        this.locale = locale;
        this.fieldName = fieldName;
    }
}