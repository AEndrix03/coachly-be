package it.coachly.api.model.workout;

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
public class WorkoutPlanTagId implements Serializable {
    private static final long serialVersionUID = 3626007257831073212L;
    @NotNull
    @Column(name = "workout_plan_id", nullable = false)
    private UUID workoutPlanId;

    @NotNull
    @Column(name = "tag_id", nullable = false)
    private UUID tagId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        WorkoutPlanTagId entity = (WorkoutPlanTagId) o;
        return Objects.equals(this.workoutPlanId, entity.workoutPlanId) &&
                Objects.equals(this.tagId, entity.tagId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workoutPlanId, tagId);
    }

}