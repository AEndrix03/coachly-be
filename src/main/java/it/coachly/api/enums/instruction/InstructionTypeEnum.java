package it.coachly.api.enums.instruction;

import it.coachly.api.util.enums.AbstractEnumConverter;
import it.coachly.api.util.enums.IEnum;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InstructionTypeEnum implements IEnum {
    SETUP("STP"),
    EXECUTION("EXE"),
    BREATHING("BRT"),
    COMMON_MISTAKES("CME");

    private final String symbol;

    @Converter(autoApply = true)
    public static class InstructionTypeEnumConverter extends AbstractEnumConverter<InstructionTypeEnum> {
        public InstructionTypeEnumConverter() {
            super(InstructionTypeEnum.class);
        }
    }
}