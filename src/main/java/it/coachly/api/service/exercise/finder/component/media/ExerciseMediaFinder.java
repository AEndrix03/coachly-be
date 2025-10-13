package it.coachly.api.service.exercise.finder.component.media;

import com.querydsl.jpa.impl.JPAQueryFactory;
import it.coachly.api.model.exercise.media.QExerciseMedia;
import it.coachly.api.service.exercise.data.component.media.ExerciseMediaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ExerciseMediaFinder {
    private final JPAQueryFactory qu;

    public List<ExerciseMediaDto> findExerciseMedia(UUID exerciseId) {
        QExerciseMedia qEM = QExerciseMedia.exerciseMedia;
        return qu.select(ExerciseMediaDto.getProjection())
                .from(qEM)
                .where(qEM.exerciseId.eq(exerciseId))
                .fetch();
    }
}
