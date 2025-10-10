package it.coachly.api.enums.muscle;

import it.coachly.api.util.enums.AbstractEnumConverter;
import it.coachly.api.util.enums.IEnum;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InvolvementLevelEnum implements IEnum {
    PRIMARY("PRM"),
    SECONDARY("SEC"),
    STABILIZER("STB");

    private final String symbol;

    @Converter(autoApply = true)
    public static class InvolvementLevelEnumConverter extends AbstractEnumConverter<InvolvementLevelEnum> {
        public InvolvementLevelEnumConverter() {
            super(InvolvementLevelEnum.class);
        }
    }
}