package it.coachly.api.enums.muscle;

import it.coachly.api.util.enums.AbstractEnumConverter;
import it.coachly.api.util.enums.IEnum;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MuscleGroupEnum implements IEnum {
    CHEST("CHT"),
    BACK("BCK"),
    SHOULDERS("SHL"),
    ARMS("ARM"),
    LEGS("LEG"),
    CORE("COR"),
    GLUTES("GLT"),
    CALVES("CLV");

    private final String symbol;

    @Converter(autoApply = true)
    public static class MuscleGroupEnumConverter extends AbstractEnumConverter<MuscleGroupEnum> {
        public MuscleGroupEnumConverter() {
            super(MuscleGroupEnum.class);
        }
    }
}