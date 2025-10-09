package it.coachly.api.service.translation;

import it.coachly.api.enums.translation.LocaleEnum;
import it.coachly.api.exception.TranslationNotFoundException;
import it.coachly.api.model.translation.Translation;
import it.coachly.api.model.translation.TranslationId;
import it.coachly.api.repository.translation.TranslationRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TranslationServiceImpl implements TranslationService {

    private final TranslationRepository translationRepository;

    @Override
    public <T> String translate(@NotNull Class<T> entityClass, @NotNull UUID key, @NotNull LocaleEnum locale, @NotNull String fieldName) {
        return this.translationRepository.findById(TranslationId.builder()
                        .entityType(entityClass.getSimpleName())
                        .entityId(key)
                        .locale(locale)
                        .fieldName(fieldName).build())
                .map(Translation::getTextValue)
                .orElseThrow(() -> new TranslationNotFoundException(
                        entityClass.getSimpleName(), key, locale, fieldName
                ));
    }

    @Override
    public <T> String translate(@NotNull Class<T> entityClass, @NotNull UUID key, @NotNull String fieldName) {
        return this.translate(entityClass, key, LocaleEnum.EN, fieldName);
    }

}
