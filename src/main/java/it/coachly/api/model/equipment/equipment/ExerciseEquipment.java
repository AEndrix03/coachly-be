package it.coachly.api.model.equipment.equipment;

import it.coachly.api.model.equipment.Equipment;
import it.coachly.api.model.exercise.core.Exercise;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exercise_equipment")
public class ExerciseEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "exercise_id", nullable = false, insertable = false, updatable = false)
    private Exercise exercise;

    @Column(name = "exercise_id", nullable = false)
    private UUID exerciseId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "equipment_id", nullable = false, insertable = false, updatable = false)
    private Equipment equipment;

    @Column(name = "equipment_id", nullable = false)
    private UUID equipmentId;

    @ColumnDefault("true")
    @Column(name = "is_required")
    private Boolean isRequired;

    @ColumnDefault("true")
    @Column(name = "is_primary")
    private Boolean isPrimary;

    @ColumnDefault("1")
    @Column(name = "quantity_needed")
    private Integer quantityNeeded;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

}