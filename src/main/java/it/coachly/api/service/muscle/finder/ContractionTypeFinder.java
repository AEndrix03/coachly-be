package it.coachly.api.service.muscle.finder;

import com.querydsl.jpa.impl.JPAQueryFactory;
import it.coachly.api.model.muscle.QContractionType;
import it.coachly.api.service.muscle.data.ContractionTypeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ContractionTypeFinder {

    private final JPAQueryFactory qu;

    public List<ContractionTypeDto> findAll() {
        return this.qu.select(ContractionTypeDto.getProjection())
                .from(QContractionType.contractionType)
                .fetch();
    }

}
