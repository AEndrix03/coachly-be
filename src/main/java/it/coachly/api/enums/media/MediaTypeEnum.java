package it.coachly.api.enums.media;

import it.coachly.api.util.enums.AbstractEnumConverter;
import it.coachly.api.util.enums.IEnum;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MediaTypeEnum implements IEnum {
    VIDEO("VID"),
    IMAGE("IMG"),
    GIF("GIF");

    private final String symbol;

    @Converter(autoApply = true)
    public static class MediaTypeEnumConverter extends AbstractEnumConverter<MediaTypeEnum> {
        public MediaTypeEnumConverter() {
            super(MediaTypeEnum.class);
        }
    }
}