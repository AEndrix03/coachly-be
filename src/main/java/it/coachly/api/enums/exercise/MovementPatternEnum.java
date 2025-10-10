package it.coachly.api.enums.exercise;

import it.coachly.api.util.enums.AbstractEnumConverter;
import it.coachly.api.util.enums.IEnum;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MovementPatternEnum implements IEnum {
    SQUAT("SQT"),
    HINGE("HNG"),
    LUNGE("LNG"),
    PUSH("PSH"),
    PULL("PLL"),
    CARRY("CRY"),
    ROTATION("ROT"),
    GAIT("GAT");

    private final String symbol;

    @Converter(autoApply = true)
    public static class MovementPatternEnumConverter extends AbstractEnumConverter<MovementPatternEnum> {
        public MovementPatternEnumConverter() {
            super(MovementPatternEnum.class);
        }
    }
}