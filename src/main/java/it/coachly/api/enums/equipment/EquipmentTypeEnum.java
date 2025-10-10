package it.coachly.api.enums.equipment;

import it.coachly.api.util.enums.AbstractEnumConverter;
import it.coachly.api.util.enums.IEnum;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EquipmentTypeEnum implements IEnum {
    BARBELL("BAR"),
    DUMBBELL("DBL"),
    KETTLEBELL("KTL"),
    MACHINE("MCH"),
    CABLE("CBL"),
    BAND("BND"),
    BENCH("BNC"),
    RACK("RCK"),
    BAR("BAR_ACC"),
    PLATE("PLT"),
    BALL("BLL");

    private final String symbol;

    @Converter(autoApply = true)
    public static class EquipmentTypeEnumConverter extends AbstractEnumConverter<EquipmentTypeEnum> {
        public EquipmentTypeEnumConverter() {
            super(EquipmentTypeEnum.class);
        }
    }
}