package it.coachly.api.enums.exercise;

import it.coachly.api.util.enums.AbstractEnumConverter;
import it.coachly.api.util.enums.IEnum;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum VariationTypeEnum implements IEnum {
    EASIER("ESR"),
    HARDER("HRD"),
    DIFFERENT_EQUIPMENT("DEQ"),
    UNILATERAL("UNI"),
    TEMPO_VARIATION("TMP");

    private final String symbol;

    @Converter(autoApply = true)
    public static class VariationTypeEnumConverter extends AbstractEnumConverter<VariationTypeEnum> {
        public VariationTypeEnumConverter() {
            super(VariationTypeEnum.class);
        }
    }
}