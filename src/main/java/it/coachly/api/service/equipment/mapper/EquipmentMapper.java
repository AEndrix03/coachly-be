package it.coachly.api.service.equipment.mapper;

import it.coachly.api.model.equipment.Equipment;
import it.coachly.api.service.equipment.data.save.EquipmentSaveDto;
import it.coachly.api.util.mapper.IEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class EquipmentMapper implements IEntityMapper<EquipmentSaveDto, Equipment> {

    @Override
    public Equipment toEntity(EquipmentSaveDto dto) {
        return Equipment.builder()
                .id(dto.getId())
                .code(dto.getCode())
                .nameI18n(dto.getNameI18n())
                .descriptionI18n(dto.getDescriptionI18n())
                .category(dto.getCategory())
                .equipmentType(dto.getEquipmentType())
                .isActive(dto.getIsActive())
                .build();
    }

}
