package it.coachly.api.service.workout.finder;

import it.coachly.api.model.workout.WorkoutPlan;
import it.coachly.api.model.workout.exercise.WorkoutExerciseGroup;
import it.coachly.api.repository.workout.WorkoutPlanRepository;
import it.coachly.api.repository.workout.exercise.WorkoutExerciseGroupRepository;
import it.coachly.api.repository.workout.exercise.WorkoutPlanExerciseRepository;
import it.coachly.api.service.exercise.finder.detail.ExerciseDetailFinder;
import it.coachly.api.service.tag.data.TagDto;
import it.coachly.api.service.workout.data.WorkoutDto;
import it.coachly.api.service.workout.data.exercise.WorkoutExerciseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class WorkoutFinder {

    private final WorkoutPlanRepository workoutPlanRepository;
    private final WorkoutPlanExerciseRepository workoutPlanExerciseRepository;
    private final WorkoutExerciseGroupRepository workoutExerciseGroupRepository;

    private final ExerciseDetailFinder exerciseDetailFinder;

    public List<WorkoutDto> findAllUserWorkouts(UUID userId) {
        List<WorkoutPlan> plans = this.workoutPlanRepository.findAllByCreatedByUserId(userId);

        return plans.stream()
                .map(this::buildWorkoutDto)
                .toList();
    }

    private WorkoutDto buildWorkoutDto(WorkoutPlan plan) {
        var groups = this.workoutExerciseGroupRepository.findAllByWorkoutPlan_Id(plan.getId());

        List<WorkoutExerciseDto> exercises = groups.stream()
                .map(WorkoutExerciseGroup::getId)
                .map(this.workoutPlanExerciseRepository::findAllByWorkoutExerciseGroup_Id)
                .map(List::getFirst)
                .map(ex ->
                        WorkoutExerciseDto.builder()
                                .exercise(this.exerciseDetailFinder.findDetailById(ex.getExercise().getId()))
                                .sets(ex.getSets().toString())
                                .rest(ex.getRestSeconds().toString())
                                .weight(ex.getWeightKg().toString())
                                .progress("10")
                                .build()
                )
                .toList();

        List<TagDto> muscleTags = new ArrayList<>();

        return WorkoutDto.builder()
                .id(plan.getId())
                .titleI18n(plan.getTitleI18n())
                .descriptionI18n(plan.getDescriptionI18n())
                .coachId(UUID.randomUUID())
                .coachName("Test")
                .progress(BigDecimal.valueOf(75.5))
                .exercises(exercises.size())
                .durationMinutes(50)
                .goal(plan.getTargetGoal())
                .lastUsed(LocalDateTime.now())
                .sessionCount(0)
                .lastSessionDays(0)
                .type(plan.getPlanType())
                .muscleTags(muscleTags)
                .workoutExercises(exercises)
                .active(plan.getIsActive())
                .build();
    }

}
