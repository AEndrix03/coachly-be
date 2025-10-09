package it.coachly.api.enums.translation;

import it.coachly.api.util.enums.AbstractEnumConverter;
import it.coachly.api.util.enums.IEnum;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LocaleEnum implements IEnum {

    IT("it-IT"),
    EN("en-US");

    private final String symbol;

    @Converter(autoApply = true)
    public static class LocaleEnumConverter extends AbstractEnumConverter<LocaleEnum> {
        public LocaleEnumConverter() {
            super(LocaleEnum.class);
        }
    }

}
