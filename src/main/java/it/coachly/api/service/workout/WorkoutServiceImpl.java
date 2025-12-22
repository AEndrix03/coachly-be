package it.coachly.api.service.workout;

import it.coachly.api.service.workout.data.WorkoutDto;
import it.coachly.api.service.workout.finder.WorkoutFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutFinder workoutFinder;

    @Override
    public List<WorkoutDto> getAllUserWorkouts(java.util.UUID userId) {
        return workoutFinder.findAllUserWorkouts(userId);
    }

}
