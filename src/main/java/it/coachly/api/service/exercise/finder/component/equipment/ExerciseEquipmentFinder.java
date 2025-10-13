package it.coachly.api.service.exercise.finder.component.equipment;

import com.querydsl.jpa.impl.JPAQueryFactory;
import it.coachly.api.model.equipment.equipment.QExerciseEquipment;
import it.coachly.api.service.exercise.data.component.equipment.ExerciseEquipmentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ExerciseEquipmentFinder {
    private final JPAQueryFactory qu;

    public List<ExerciseEquipmentDto> findExerciseEquipments(UUID exerciseId) {
        QExerciseEquipment qEE = QExerciseEquipment.exerciseEquipment;
        return qu.select(ExerciseEquipmentDto.getProjection())
                .from(qEE)
                .where(qEE.exerciseId.eq(exerciseId))
                .fetch();
    }
}
