package it.coachly.api.service.exercise.mapper.component.equipment;

import it.coachly.api.model.equipment.equipment.ExerciseEquipment;
import it.coachly.api.service.exercise.data.component.equipment.save.ExerciseEquipmentSaveDto;
import it.coachly.api.util.mapper.IEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class ExerciseEquipmentMapper implements IEntityMapper<ExerciseEquipmentSaveDto, ExerciseEquipment> {
    @Override
    public ExerciseEquipment toEntity(ExerciseEquipmentSaveDto dto) {
        return ExerciseEquipment.builder()
                .exerciseId(dto.getExerciseId())
                .equipmentId(dto.getEquipmentId())
                .isRequired(dto.getIsRequired())
                .isPrimary(dto.getIsPrimary())
                .quantityNeeded(dto.getQuantityNeeded())
                .build();
    }
}

