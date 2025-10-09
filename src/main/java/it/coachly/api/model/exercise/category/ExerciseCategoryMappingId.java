package it.coachly.api.model.exercise.category;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Embeddable
public class ExerciseCategoryMappingId implements Serializable {
    private static final long serialVersionUID = -194923969245601990L;
    @NotNull
    @Column(name = "exercise_id", nullable = false)
    private UUID exerciseId;

    @NotNull
    @Column(name = "category_id", nullable = false)
    private UUID categoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ExerciseCategoryMappingId entity = (ExerciseCategoryMappingId) o;
        return Objects.equals(this.exerciseId, entity.exerciseId) &&
                Objects.equals(this.categoryId, entity.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exerciseId, categoryId);
    }

}