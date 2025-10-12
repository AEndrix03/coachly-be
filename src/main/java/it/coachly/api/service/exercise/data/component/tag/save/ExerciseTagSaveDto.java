package it.coachly.api.service.exercise.data.component.tag.save;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@SuperBuilder
public class ExerciseTagSaveDto {
    private final UUID exerciseId;
    private final UUID tagId;

    public ExerciseTagSaveDto(UUID exerciseId, UUID tagId) {
        this.exerciseId = exerciseId;
        this.tagId = tagId;
    }
}
