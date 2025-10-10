package it.coachly.api.enums.media;

import it.coachly.api.util.enums.AbstractEnumConverter;
import it.coachly.api.util.enums.IEnum;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MediaPurposeEnum implements IEnum {
    TUTORIAL("TUT"),
    DEMO("DMO"),
    FORM_CHECK("FCK"),
    THUMBNAIL("THB");

    private final String symbol;

    @Converter(autoApply = true)
    public static class MediaPurposeEnumConverter extends AbstractEnumConverter<MediaPurposeEnum> {
        public MediaPurposeEnumConverter() {
            super(MediaPurposeEnum.class);
        }
    }
}