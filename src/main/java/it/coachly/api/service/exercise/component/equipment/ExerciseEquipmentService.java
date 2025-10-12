package it.coachly.api.service.exercise.component.equipment;

import it.coachly.api.service.exercise.data.component.equipment.save.ExerciseEquipmentSaveDto;

import java.util.List;
import java.util.UUID;

public interface ExerciseEquipmentService {
    UUID save(ExerciseEquipmentSaveDto dto);

    List<UUID> saveAll(List<ExerciseEquipmentSaveDto> dtos);

    void deleteById(UUID id);
}

