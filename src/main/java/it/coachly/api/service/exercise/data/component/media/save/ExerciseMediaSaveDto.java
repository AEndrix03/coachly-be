package it.coachly.api.service.exercise.data.component.media.save;

import it.coachly.api.enums.media.MediaPurposeEnum;
import it.coachly.api.enums.media.MediaTypeEnum;
import it.coachly.api.enums.media.ViewAngleEnum;
import it.coachly.api.service.exercise.data.component.media.ExerciseMediaDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@SuperBuilder
public class ExerciseMediaSaveDto extends ExerciseMediaDto {
    private final UUID exerciseId;

    public ExerciseMediaSaveDto(UUID id, MediaTypeEnum mediaType, String mediaUrl, String thumbnailUrl, MediaPurposeEnum mediaPurpose, ViewAngleEnum viewAngle, Boolean isPrimary, Boolean isPublic, UUID exerciseId) {
        super(id, mediaType, mediaUrl, thumbnailUrl, mediaPurpose, viewAngle, isPrimary, isPublic);
        this.exerciseId = exerciseId;
    }
}

