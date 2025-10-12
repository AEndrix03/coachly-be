package it.coachly.api.service.exercise.data.component.equipment.save;

import it.coachly.api.service.equipment.data.EquipmentDto;
import it.coachly.api.service.exercise.data.component.equipment.ExerciseEquipmentDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@SuperBuilder
public class ExerciseEquipmentSaveDto extends ExerciseEquipmentDto {
    private final UUID exerciseId;
    private final UUID equipmentId;

    public ExerciseEquipmentSaveDto(EquipmentDto equipment, Boolean isRequired, Boolean isPrimary, Integer quantityNeeded, UUID exerciseId, UUID equipmentId) {
        super(equipment, isRequired, isPrimary, quantityNeeded);
        this.exerciseId = exerciseId;
        this.equipmentId = equipmentId;
    }
}

