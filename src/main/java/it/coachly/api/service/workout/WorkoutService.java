package it.coachly.api.service.workout;

import it.coachly.api.service.workout.data.WorkoutDto;

import java.util.List;
import java.util.UUID;

public interface WorkoutService {
    List<WorkoutDto> getAllUserWorkouts(java.util.UUID userId);

    UUID patchWorkout(WorkoutDto workoutDto);
}
