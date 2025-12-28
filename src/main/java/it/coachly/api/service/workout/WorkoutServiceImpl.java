package it.coachly.api.service.workout;

import it.coachly.api.model.exercise.core.Exercise;
import it.coachly.api.model.workout.WorkoutPlan;
import it.coachly.api.model.workout.WorkoutPlanExercise;
import it.coachly.api.model.workout.exercise.WorkoutExerciseGroup;
import it.coachly.api.repository.exercise.core.ExerciseRepository;
import it.coachly.api.repository.workout.WorkoutPlanRepository;
import it.coachly.api.repository.workout.exercise.WorkoutExerciseGroupRepository;
import it.coachly.api.repository.workout.exercise.WorkoutPlanExerciseRepository;
import it.coachly.api.service.workout.data.WorkoutDto;
import it.coachly.api.service.workout.finder.WorkoutFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutFinder workoutFinder;

    private final WorkoutPlanRepository workoutPlanRepository;
    private final WorkoutPlanExerciseRepository workoutPlanExerciseRepository;
    private final WorkoutExerciseGroupRepository workoutExerciseGroupRepository;
    private final ExerciseRepository exerciseRepository;

    @Override
    public List<WorkoutDto> getAllUserWorkouts(UUID userId) {
        return workoutFinder.findAllUserWorkouts(userId);
    }

    @Override
    public UUID patchWorkout(WorkoutDto workoutDto) {
        WorkoutPlan plan = workoutDto.getId() != null ? this.workoutPlanRepository.findById(workoutDto.getId())
                .orElse(new WorkoutPlan()) : new WorkoutPlan();

        plan.setTitleI18n(workoutDto.getTitleI18n());
        plan.setDescriptionI18n(workoutDto.getDescriptionI18n());
        plan.setIsActive(workoutDto.getActive());

        plan = this.workoutPlanRepository.save(plan);

        for (var exercise : workoutDto.getWorkoutExercises()) {
            WorkoutPlanExercise ex = exercise.getId() != null ? this.workoutPlanExerciseRepository.findById(exercise.getId())
                    .orElse(new WorkoutPlanExercise()) : new WorkoutPlanExercise();
            Exercise _ex = this.exerciseRepository.findById(exercise.getExercise().getId()).orElseThrow(); // TODO: New exercise (future)

            if (ex.getWorkoutExerciseGroup() == null) {
                // Aggiunto
                WorkoutExerciseGroup grp = new WorkoutExerciseGroup();
                grp.setWorkoutPlan(plan);
                ex.setWorkoutExerciseGroup(grp);
            }

            ex.setExercise(_ex);
            ex.setSets(Integer.parseInt(exercise.getSets()));
            ex.setRestSeconds(Integer.parseInt(exercise.getRest()));
            ex.setWeightKg(BigDecimal.valueOf(Long.parseLong(exercise.getWeight())));

            this.workoutPlanExerciseRepository.save(ex);
        }

        return this.workoutPlanRepository.save(plan).getId();
    }
}
