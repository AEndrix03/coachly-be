package it.coachly.api.service.exercise.data.component.equipment;

import com.querydsl.core.annotations.QueryProjection;
import it.coachly.api.model.equipment.equipment.QExerciseEquipment;
import it.coachly.api.service.equipment.data.EquipmentDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@RequiredArgsConstructor
public class ExerciseEquipmentDto {

    private EquipmentDto equipment;
    private Boolean isRequired;
    private Boolean isPrimary;
    private Integer quantityNeeded;

    @QueryProjection
    public ExerciseEquipmentDto(EquipmentDto equipment, Boolean isRequired, Boolean isPrimary, Integer quantityNeeded) {
        this.equipment = equipment;
        this.isRequired = isRequired;
        this.isPrimary = isPrimary;
        this.quantityNeeded = quantityNeeded;
    }

    public static QExerciseEquipmentDto getProjection() {
        QExerciseEquipment qEE = QExerciseEquipment.exerciseEquipment;
        return new QExerciseEquipmentDto(
                EquipmentDto.getProjection(),
                qEE.isRequired,
                qEE.isPrimary,
                qEE.quantityNeeded
        );
    }

}
