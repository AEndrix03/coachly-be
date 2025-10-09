package it.coachly.api.repository.equipment;

import it.coachly.api.model.equipment.Equipment;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface EquipmentRepository extends JpaRepository<Equipment, UUID>, QuerydslPredicateExecutor<Equipment> {
}
