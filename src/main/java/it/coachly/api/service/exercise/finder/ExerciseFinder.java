package it.coachly.api.service.exercise.finder;

import com.querydsl.jpa.impl.JPAQueryFactory;
import it.coachly.api.model.exercise.core.QExercise;
import it.coachly.api.service.exercise.data.ExerciseDto;
import it.coachly.api.util.page.PaginationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ExerciseFinder {

    private final JPAQueryFactory qu;

    public Page<ExerciseDto> findPaginated(Pageable pageable) {
        return PaginationUtils.findPaginated(
                this.qu.select(ExerciseDto.getProjection())
                        .from(QExercise.exercise),
                pageable);
    }

    public ExerciseDto findAll() {
        return this.qu.select(ExerciseDto.getProjection())
                .from(QExercise.exercise)
                .fetchOne();
    }

    public ExerciseDto findById(UUID id) {
        QExercise qE = QExercise.exercise;
        return this.qu.select(ExerciseDto.getProjection())
                .from(qE)
                .where(qE.id.eq(id))
                .fetchOne();
    }
}
