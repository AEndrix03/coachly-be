package it.coachly.api.enums.exercise;

import it.coachly.api.util.enums.AbstractEnumConverter;
import it.coachly.api.util.enums.IEnum;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MechanicsTypeEnum implements IEnum {
    COMPOUND("CMP"),
    ISOLATION("ISO");

    private final String symbol;

    @Converter(autoApply = true)
    public static class MechanicsTypeEnumConverter extends AbstractEnumConverter<MechanicsTypeEnum> {
        public MechanicsTypeEnumConverter() {
            super(MechanicsTypeEnum.class);
        }
    }
}
