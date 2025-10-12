package it.coachly.api.service.exercise.finder.category;

import com.querydsl.jpa.impl.JPAQueryFactory;
import it.coachly.api.model.exercise.category.QExerciseCategory;
import it.coachly.api.model.exercise.category.QExerciseCategoryMapping;
import it.coachly.api.service.exercise.data.category.ExerciseCategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ExerciseCategoryFinder {

    private final JPAQueryFactory qu;

    public List<ExerciseCategoryDto> findExerciseCategories() {
        QExerciseCategory qEC = QExerciseCategory.exerciseCategory;

        return this.qu.select(ExerciseCategoryDto.getBaseProjection())
                .from(qEC)
                .where(qEC.parentCategory.parentCategory.isNull(), qEC.isActive.isTrue())
                .orderBy(qEC.displayOrder.asc())
                .fetch()
                .stream()
                .map(cat -> {
                    cat.setChildren(findExerciseSubCategory(cat));
                    return cat;
                })
                .toList();
    }

    public List<ExerciseCategoryDto> findExerciseCategory(UUID exerciseId) {
        QExerciseCategory qEC = QExerciseCategory.exerciseCategory;
        QExerciseCategoryMapping qECM = QExerciseCategoryMapping.exerciseCategoryMapping;
        return this.qu.select(ExerciseCategoryDto.getProjection())
                .from(qEC)
                .innerJoin(qECM).on(qECM.category.id.eq(qEC.id))
                .where(qECM.exercise.id.eq(exerciseId), qEC.isActive.isTrue())
                .orderBy(qEC.displayOrder.asc())
                .fetch();
    }

    private List<ExerciseCategoryDto> findExerciseSubCategory(ExerciseCategoryDto superCategory) {
        QExerciseCategory qEC = QExerciseCategory.exerciseCategory;

        return this.qu.select(ExerciseCategoryDto.getBaseProjection())
                .from(qEC)
                .where(qEC.parentCategory.id.eq(superCategory.getId()), qEC.isActive.isTrue())
                .orderBy(qEC.displayOrder.asc())
                .fetch()
                .stream()
                .map(cat -> {
                    cat.setChildren(findExerciseSubCategory(cat));
                    return cat;
                })
                .toList();
    }

}
