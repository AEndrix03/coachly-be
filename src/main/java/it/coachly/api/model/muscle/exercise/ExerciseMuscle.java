package it.coachly.api.model.muscle.exercise;

import it.coachly.api.enums.muscle.InvolvementLevelEnum;
import it.coachly.api.model.exercise.core.Exercise;
import it.coachly.api.model.muscle.ContractionType;
import it.coachly.api.model.muscle.Muscle;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Table(name = "exercise_muscles")
public class ExerciseMuscle {
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
    @JoinColumn(name = "muscle_id", nullable = false)
    private Muscle muscle;

    @Size(max = 30)
    @NotNull
    @Column(name = "involvement_level", nullable = false, length = 30)
    private InvolvementLevelEnum involvementLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "primary_contraction_type_id")
    private ContractionType primaryContractionType;

    @Column(name = "activation_percentage")
    private Integer activationPercentage;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

}