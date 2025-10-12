package it.coachly.api.service.equipment;

import it.coachly.api.service.equipment.data.save.EquipmentSaveDto;

import java.util.UUID;

public interface EquipmentService {
    UUID save(EquipmentSaveDto equipment);

    void deleteById(UUID id);
}
