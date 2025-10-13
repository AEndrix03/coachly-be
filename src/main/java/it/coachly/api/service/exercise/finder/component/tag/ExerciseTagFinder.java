package it.coachly.api.service.exercise.finder.component.tag;

import com.querydsl.jpa.impl.JPAQueryFactory;
import it.coachly.api.model.tag.QTag;
import it.coachly.api.model.tag.exercise.QExerciseTag;
import it.coachly.api.service.tag.data.TagDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ExerciseTagFinder {
    private final JPAQueryFactory qu;

    public List<TagDto> findExerciseTags(UUID exerciseId) {
        QExerciseTag qET = QExerciseTag.exerciseTag;
        QTag qT = QTag.tag;
        return qu.select(TagDto.getProjection())
                .from(qET)
                .innerJoin(qT).on(qET.tag.id.eq(qT.id))
                .where(qET.exercise.id.eq(exerciseId))
                .fetch();
    }
}
