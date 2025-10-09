package it.coachly.api.model.exercise.media;

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
@Table(name = "exercise_media")
public class ExerciseMedia {
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
    @Column(name = "media_type", nullable = false, length = 30)
    private String mediaType;

    @Size(max = 500)
    @NotNull
    @Column(name = "media_url", nullable = false, length = 500)
    private String mediaUrl;

    @Size(max = 500)
    @Column(name = "thumbnail_url", length = 500)
    private String thumbnailUrl;

    @Size(max = 50)
    @NotNull
    @Column(name = "media_purpose", nullable = false, length = 50)
    private String mediaPurpose;

    @Size(max = 50)
    @Column(name = "view_angle", length = 50)
    private String viewAngle;

    @ColumnDefault("0")
    @Column(name = "display_order")
    private Integer displayOrder;

    @ColumnDefault("false")
    @Column(name = "is_primary")
    private Boolean isPrimary;

    @ColumnDefault("true")
    @Column(name = "is_public")
    private Boolean isPublic;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

}