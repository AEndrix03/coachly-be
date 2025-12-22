package it.coachly.api.service.equipment.data.save;

import it.coachly.api.enums.equipment.EquipmentCategoryEnum;
import it.coachly.api.enums.equipment.EquipmentTypeEnum;
import it.coachly.api.service.equipment.data.EquipmentDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.Map;
import java.util.UUID;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class EquipmentSaveDto extends EquipmentDto {

    private Boolean isActive;

    public EquipmentSaveDto(UUID id, String code, Map<String, String> nameI18n, Map<String, String> descriptionI18n, EquipmentCategoryEnum category, EquipmentTypeEnum equipmentType, Boolean isActive) {
        super(id, code, nameI18n, descriptionI18n, category, equipmentType);
        this.isActive = isActive;
    }
}
