package it.coachly.api.enums;

import it.coachly.api.util.enums.AbstractEnumConverter;
import it.coachly.api.util.enums.IEnum;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DifficultyLevelEnum implements IEnum {

    VERY_EASY("VSY"),
    EASY("ESY"),
    MEDIUM("MED"),
    HARD("HRD"),
    VERY_HARD("VHR");

    private final String symbol;

    @Converter(autoApply = true)
    public static class DifficultyLevelEnumConverter extends AbstractEnumConverter<DifficultyLevelEnum> {
        public DifficultyLevelEnumConverter() {
            super(DifficultyLevelEnum.class);
        }
    }


}
