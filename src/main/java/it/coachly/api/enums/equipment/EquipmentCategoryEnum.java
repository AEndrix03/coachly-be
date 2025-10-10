package it.coachly.api.enums.equipment;

import it.coachly.api.util.enums.AbstractEnumConverter;
import it.coachly.api.util.enums.IEnum;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EquipmentCategoryEnum implements IEnum {
    FREE_WEIGHTS("FRW"),
    MACHINES("MCH"),
    BODYWEIGHT("BDW"),
    CARDIO("CRD"),
    RESISTANCE_BANDS("RBD"),
    CABLES("CBL"),
    ACCESSORIES("ACC");

    private final String symbol;

    @Converter(autoApply = true)
    public static class EquipmentCategoryEnumConverter extends AbstractEnumConverter<EquipmentCategoryEnum> {
        public EquipmentCategoryEnumConverter() {
            super(EquipmentCategoryEnum.class);
        }
    }
}