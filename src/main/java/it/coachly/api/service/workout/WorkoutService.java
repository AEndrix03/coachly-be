package it.coachly.api.service.workout;

import it.coachly.api.service.workout.data.WorkoutDto;

import java.util.List;

public interface WorkoutService {
    List<WorkoutDto> getAllUserWorkouts(java.util.UUID userId);
}
