package it.coachly.api.model.exercise.safety;

import it.coachly.api.model.exercise.core.Exercise;
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
@Table(name = "exercise_safety")
public class ExerciseSafety {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "exercise_id", nullable = false)
    private UUID id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercises;

    @Size(max = 20)
    @NotNull
    @Column(name = "overall_risk_level", nullable = false, length = 20)
    private String overallRiskLevel;

    @ColumnDefault("false")
    @Column(name = "spotter_required")
    private Boolean spotterRequired;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

}