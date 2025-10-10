package it.coachly.api.enums.safety;

import it.coachly.api.util.enums.AbstractEnumConverter;
import it.coachly.api.util.enums.IEnum;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ContraindicationTypeEnum implements IEnum {
    INJURY("INJ"),
    MEDICAL_CONDITION("MED"),
    PREGNANCY("PRG"),
    AGE_RELATED("AGE");

    private final String symbol;

    @Converter(autoApply = true)
    public static class ContraindicationTypeEnumConverter extends AbstractEnumConverter<ContraindicationTypeEnum> {
        public ContraindicationTypeEnumConverter() {
            super(ContraindicationTypeEnum.class);
        }
    }
}