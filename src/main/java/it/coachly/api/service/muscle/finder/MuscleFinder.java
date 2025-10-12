package it.coachly.api.service.muscle.finder;

import com.querydsl.jpa.impl.JPAQueryFactory;
import it.coachly.api.model.muscle.QMuscle;
import it.coachly.api.service.muscle.data.MuscleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MuscleFinder {

    private final JPAQueryFactory qu;

    public List<MuscleDto> findAll() {
        return this.qu.select(MuscleDto.getProjection())
                .from(QMuscle.muscle)
                .fetch();
    }

}
