package it.coachly.api.model.muscle;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "muscles")
public class Muscle {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @Size(max = 150)
    @NotNull
    @Column(name = "code", nullable = false, length = 150)
    private String code;

    @Size(max = 50)
    @NotNull
    @Column(name = "muscle_group", nullable = false, length = 50)
    private String muscleGroup;

    @Size(max = 100)
    @Column(name = "muscle_subgroup", length = 100)
    private String muscleSubgroup;

    @Size(max = 255)
    @Column(name = "anatomical_name")
    private String anatomicalName;

    @ColumnDefault("true")
    @Column(name = "is_active")
    private Boolean isActive;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

}