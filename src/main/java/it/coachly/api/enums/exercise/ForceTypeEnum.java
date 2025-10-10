package it.coachly.api.enums.exercise;

import it.coachly.api.util.enums.AbstractEnumConverter;
import it.coachly.api.util.enums.IEnum;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ForceTypeEnum implements IEnum {
    PUSH("PSH"),
    PULL("PLL"),
    STATIC("STC");

    private final String symbol;

    @Converter(autoApply = true)
    public static class ForceTypeEnumConverter extends AbstractEnumConverter<ForceTypeEnum> {
        public ForceTypeEnumConverter() {
            super(ForceTypeEnum.class);
        }
    }
}