package it.coachly.api.model.exercise.core;

import it.coachly.api.enums.DifficultyLevelEnum;
import it.coachly.api.enums.exercise.ForceTypeEnum;
import it.coachly.api.enums.exercise.MechanicsTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    // Campi tradotti JSONB
    @NotNull
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "name_i18n", nullable = false, columnDefinition = "jsonb")
    private Map<String, String> nameI18n;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "description_i18n", columnDefinition = "jsonb")
    private Map<String, String> descriptionI18n;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "tips_i18n", columnDefinition = "jsonb")
    private Map<String, String> tipsI18n;

    @Size(max = 20)
    @NotNull
    @Column(name = "difficulty_level", nullable = false, length = 20)
    private DifficultyLevelEnum difficultyLevel;

    @Size(max = 20)
    @NotNull
    @Column(name = "mechanics_type", nullable = false, length = 20)
    private MechanicsTypeEnum mechanicsType;

    @Size(max = 20)
    @Column(name = "force_type", length = 20)
    private ForceTypeEnum forceType;

    @ColumnDefault("false")
    @Column(name = "is_unilateral")
    private Boolean isUnilateral;

    @ColumnDefault("false")
    @Column(name = "is_bodyweight")
    private Boolean isBodyweight;

    @ColumnDefault("false")
    @Column(name = "is_custom")
    private Boolean isCustom;

    @Column(name = "created_by")
    private UUID createdBy;

    @ColumnDefault("true")
    @Column(name = "is_active")
    private Boolean isActive;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("now()")
    @Column(name = "updated_at")
    private Instant updatedAt;
}