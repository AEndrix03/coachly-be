package it.coachly.api.model.exercise.core;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "exercise_environment")
public class ExerciseEnvironment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "exercise_id", nullable = false)
    private UUID id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "exercise_id", nullable = false, insertable = false, updatable = false)
    private Exercise exercises;

    @Column(name = "exercise_id", nullable = false)
    private UUID exerciseId;

    @ColumnDefault("false")
    @Column(name = "can_do_at_home")
    private Boolean canDoAtHome;

    @ColumnDefault("true")
    @Column(name = "can_do_in_gym")
    private Boolean canDoInGym;

    @ColumnDefault("false")
    @Column(name = "equipment_setup_required")
    private Boolean equipmentSetupRequired;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

}