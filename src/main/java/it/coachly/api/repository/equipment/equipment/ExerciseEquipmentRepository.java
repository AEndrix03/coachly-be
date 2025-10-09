package it.coachly.api.repository.equipment.equipment;

import it.coachly.api.model.equipment.equipment.ExerciseEquipment;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ExerciseEquipmentRepository extends JpaRepository<ExerciseEquipment, UUID>, QuerydslPredicateExecutor<ExerciseEquipment> {
}
