package it.coachly.api.service.exercise.mapper.component.media;

import it.coachly.api.model.exercise.media.ExerciseMedia;
import it.coachly.api.service.exercise.data.component.media.save.ExerciseMediaSaveDto;
import it.coachly.api.util.mapper.IEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class ExerciseMediaMapper implements IEntityMapper<ExerciseMediaSaveDto, ExerciseMedia> {
    @Override
    public ExerciseMedia toEntity(ExerciseMediaSaveDto dto) {
        return ExerciseMedia.builder()
                .id(dto.getId())
                .exerciseId(dto.getExerciseId())
                .mediaType(dto.getMediaType())
                .mediaUrl(dto.getMediaUrl())
                .thumbnailUrl(dto.getThumbnailUrl())
                .mediaPurpose(dto.getMediaPurpose())
                .viewAngle(dto.getViewAngle())
                .isPrimary(dto.getIsPrimary())
                .isPublic(dto.getIsPublic())
                .build();
    }
}

