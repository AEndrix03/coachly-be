package it.coachly.api.model.exercise.core;

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
@Table(name = "exercise_instructions")
public class ExerciseInstruction {
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

    @Size(max = 30)
    @NotNull
    @Column(name = "instruction_type", nullable = false, length = 30)
    private String instructionType;

    @NotNull
    @Column(name = "step_number", nullable = false)
    private Integer stepNumber;

    // Campo tradotto JSONB
    @NotNull
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "instruction_text_i18n", nullable = false, columnDefinition = "jsonb")
    private Map<String, String> instructionTextI18n;

    @ColumnDefault("false")
    @Column(name = "is_critical")
    private Boolean isCritical;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;
}