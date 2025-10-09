package it.coachly.api.service.translation;

import it.coachly.api.enums.translation.LocaleEnum;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public interface TranslationService {
    <T> String translate(@NotNull Class<T> entityClass, @NotNull UUID key, @NotNull LocaleEnum locale, @NotNull String fieldName);

    <T> String translate(@NotNull Class<T> entityClass, @NotNull UUID key, @NotNull String fieldName);
}
