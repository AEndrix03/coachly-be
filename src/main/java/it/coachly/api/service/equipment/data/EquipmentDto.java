package it.coachly.api.service.equipment.data;

import com.querydsl.core.annotations.QueryProjection;
import it.coachly.api.enums.equipment.EquipmentCategoryEnum;
import it.coachly.api.enums.equipment.EquipmentTypeEnum;
import it.coachly.api.model.equipment.QEquipment;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class EquipmentDto {

    private UUID id;
    private String code;
    private Map<String, String> nameI18n;
    private Map<String, String> descriptionI18n;
    private EquipmentCategoryEnum category;
    private EquipmentTypeEnum equipmentType;

    @QueryProjection
    public EquipmentDto(UUID id, String code, Map<String, String> nameI18n, Map<String, String> descriptionI18n, EquipmentCategoryEnum category, EquipmentTypeEnum equipmentType) {
        this.id = id;
        this.code = code;
        this.nameI18n = nameI18n;
        this.descriptionI18n = descriptionI18n;
        this.category = category;
        this.equipmentType = equipmentType;
    }

    public static QEquipmentDto getProjection() {
        QEquipment qE = QEquipment.equipment;
        return new QEquipmentDto(
                qE.id,
                qE.code,
                qE.nameI18n,
                qE.descriptionI18n,
                qE.category,
                qE.equipmentType
        );
    }
}
