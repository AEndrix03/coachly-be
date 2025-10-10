package it.coachly.api.enums.muscle;

import it.coachly.api.util.enums.AbstractEnumConverter;
import it.coachly.api.util.enums.IEnum;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MuscleSubgroupEnum implements IEnum {
    // CHEST
    UPPER_CHEST("UCH"),
    MIDDLE_CHEST("MCH"),
    LOWER_CHEST("LCH"),

    // BACK
    LATS("LAT"),
    TRAPS("TRP"),
    RHOMBOIDS("RHO"),
    ERECTOR_SPINAE("ERE"),
    TERES("TER"),

    // SHOULDERS
    ANTERIOR_DELTOID("ADL"),
    LATERAL_DELTOID("LDL"),
    POSTERIOR_DELTOID("PDL"),

    // ARMS
    BICEPS("BIC"),
    TRICEPS("TRI"),
    FOREARMS("FOR"),

    // LEGS
    QUADRICEPS("QUA"),
    HAMSTRINGS("HAM"),
    ADDUCTORS("ADD"),
    ABDUCTORS("ABD"),

    // CORE
    ABS("ABS"),
    OBLIQUES("OBL"),
    TRANSVERSE_ABDOMINIS("TRA"),

    // GLUTES
    GLUTEUS_MAXIMUS("GMX"),
    GLUTEUS_MEDIUS("GMD"),
    GLUTEUS_MINIMUS("GMN"),

    // CALVES
    GASTROCNEMIUS("GAS"),
    SOLEUS("SOL");

    private final String symbol;

    @Converter(autoApply = true)
    public static class MuscleSubgroupEnumConverter extends AbstractEnumConverter<MuscleSubgroupEnum> {
        public MuscleSubgroupEnumConverter() {
            super(MuscleSubgroupEnum.class);
        }
    }
}