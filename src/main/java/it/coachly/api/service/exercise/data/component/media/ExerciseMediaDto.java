package it.coachly.api.service.exercise.data.component.media;

import com.querydsl.core.annotations.QueryProjection;
import it.coachly.api.enums.media.MediaPurposeEnum;
import it.coachly.api.enums.media.MediaTypeEnum;
import it.coachly.api.enums.media.ViewAngleEnum;
import it.coachly.api.model.exercise.media.QExerciseMedia;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@SuperBuilder
public class ExerciseMediaDto {

    private UUID id;
    private MediaTypeEnum mediaType;
    private String mediaUrl;
    private String thumbnailUrl;
    private MediaPurposeEnum mediaPurpose;
    private ViewAngleEnum viewAngle;
    private Boolean isPrimary;
    private Boolean isPublic;

    @QueryProjection
    public ExerciseMediaDto(UUID id, MediaTypeEnum mediaType, String mediaUrl, String thumbnailUrl, MediaPurposeEnum mediaPurpose, ViewAngleEnum viewAngle, Boolean isPrimary, Boolean isPublic) {
        this.id = id;
        this.mediaType = mediaType;
        this.mediaUrl = mediaUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.mediaPurpose = mediaPurpose;
        this.viewAngle = viewAngle;
        this.isPrimary = isPrimary;
        this.isPublic = isPublic;
    }

    public static QExerciseMediaDto getProjection() {
        QExerciseMedia qEM = QExerciseMedia.exerciseMedia;
        return new QExerciseMediaDto(
                qEM.id,
                qEM.mediaType,
                qEM.mediaUrl,
                qEM.thumbnailUrl,
                qEM.mediaPurpose,
                qEM.viewAngle,
                qEM.isPrimary,
                qEM.isPublic
        );
    }
}
