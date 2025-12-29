package it.coachly.api.service.exercise.data.component.tag.save;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@SuperBuilder
@NoArgsConstructor
public class ExerciseTagSaveDto {
    private UUID exerciseId;
    private UUID tagId;

    public ExerciseTagSaveDto(UUID exerciseId, UUID tagId) {
        this.exerciseId = exerciseId;
        this.tagId = tagId;
    }
}
