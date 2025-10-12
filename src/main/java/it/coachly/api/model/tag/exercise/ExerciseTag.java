package it.coachly.api.model.tag.exercise;

import it.coachly.api.model.exercise.core.Exercise;
import it.coachly.api.model.tag.Tag;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "exercise_tags")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseTag {
    @EmbeddedId
    private ExerciseTagId id;

    @MapsId("exerciseId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "exercise_id", nullable = false, insertable = false, updatable = false)
    private Exercise exercise;

    @MapsId("tagId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

}