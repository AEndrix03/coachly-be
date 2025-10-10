package it.coachly.api.enums.exercise;

import it.coachly.api.util.enums.AbstractEnumConverter;
import it.coachly.api.util.enums.IEnum;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MovementPlaneEnum implements IEnum {
    SAGITTAL("SAG"),
    FRONTAL("FRO"),
    TRANSVERSE("TRN"),
    MULTI_PLANAR("MUL");

    private final String symbol;

    @Converter(autoApply = true)
    public static class MovementPlaneEnumConverter extends AbstractEnumConverter<MovementPlaneEnum> {
        public MovementPlaneEnumConverter() {
            super(MovementPlaneEnum.class);
        }
    }
}