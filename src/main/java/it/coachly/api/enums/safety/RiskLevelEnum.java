package it.coachly.api.enums.safety;

import it.coachly.api.util.enums.AbstractEnumConverter;
import it.coachly.api.util.enums.IEnum;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RiskLevelEnum implements IEnum {
    LOW("LOW"),
    MODERATE("MOD"),
    HIGH("HGH"),
    VERY_HIGH("VHG");

    private final String symbol;

    @Converter(autoApply = true)
    public static class RiskLevelEnumConverter extends AbstractEnumConverter<RiskLevelEnum> {
        public RiskLevelEnumConverter() {
            super(RiskLevelEnum.class);
        }
    }
}