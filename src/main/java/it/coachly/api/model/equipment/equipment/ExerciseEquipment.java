package it.coachly.api.model.equipment.equipment;

import it.coachly.api.model.exercise.core.Exercise;
import it.coachly.api.model.equipment.Equipment;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
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
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "equipment_id", nullable = false)
    private Equipment equipment;

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