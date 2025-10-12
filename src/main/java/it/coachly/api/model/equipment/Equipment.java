package it.coachly.api.model.equipment;

import it.coachly.api.enums.equipment.EquipmentCategoryEnum;
import it.coachly.api.enums.equipment.EquipmentTypeEnum;
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
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "equipment")
public class Equipment {
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

    @Size(max = 50)
    @NotNull
    @Column(name = "category", nullable = false, length = 50)
    private EquipmentCategoryEnum category;

    @Size(max = 50)
    @Column(name = "equipment_type", length = 50)
    private EquipmentTypeEnum equipmentType;

    @ColumnDefault("true")
    @Column(name = "is_active")
    private Boolean isActive;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;
}