package it.coachly.api.model.tag.exercise;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseTagId implements Serializable {
    private static final long serialVersionUID = -2204096133940391718L;
    @NotNull
    @Column(name = "exercise_id", nullable = false)
    private UUID exerciseId;

    @NotNull
    @Column(name = "tag_id", nullable = false)
    private UUID tagId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ExerciseTagId entity = (ExerciseTagId) o;
        return Objects.equals(this.exerciseId, entity.exerciseId) &&
                Objects.equals(this.tagId, entity.tagId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exerciseId, tagId);
    }

}