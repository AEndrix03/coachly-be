package it.coachly.api.model.exercise.safety;

import it.coachly.api.enums.safety.ContraindicationTypeEnum;
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
@Table(name = "exercise_safety_contraindications")
public class ExerciseSafetyContraindication {
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

    @Size(max = 20)
    @NotNull
    @Column(name = "contraindication_type", nullable = false, length = 20)
    private ContraindicationTypeEnum contraindicationType;

    @Size(max = 100)
    @NotNull
    @Column(name = "condition_name", nullable = false, length = 100)
    private String conditionName;

    // Campo tradotto JSONB
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "warning_text_i18n", columnDefinition = "jsonb")
    private Map<String, String> warningTextI18n;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;
}