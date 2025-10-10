package it.coachly.api.model.exercise.safety;

import it.coachly.api.enums.safety.RiskLevelEnum;
import it.coachly.api.model.exercise.core.Exercise;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.Map;
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
    private RiskLevelEnum overallRiskLevel;

    @ColumnDefault("false")
    @Column(name = "spotter_required")
    private Boolean spotterRequired;

    // Campo tradotto JSONB
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "safety_notes_i18n", columnDefinition = "jsonb")
    private Map<String, String> safetyNotesI18n;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;
}