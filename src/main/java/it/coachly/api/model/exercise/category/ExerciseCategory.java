package it.coachly.api.model.exercise.category;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exercise_categories")
public class ExerciseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @Size(max = 150)
    @NotNull
    @Column(name = "code", nullable = false, length = 150)
    private String code;

    // Campi tradotti JSONB
    @NotNull
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "name_i18n", nullable = false, columnDefinition = "jsonb")
    private Map<String, String> nameI18n;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "description_i18n", columnDefinition = "jsonb")
    private Map<String, String> descriptionI18n;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_category_id")
    private ExerciseCategory parentCategory;

    @ColumnDefault("1")
    @Column(name = "category_level")
    private Integer categoryLevel;

    @ColumnDefault("0")
    @Column(name = "display_order")
    private Integer displayOrder;

    @ColumnDefault("true")
    @Column(name = "is_active")
    private Boolean isActive;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;
}