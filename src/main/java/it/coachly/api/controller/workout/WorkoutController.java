package it.coachly.api.controller.workout;

import it.coachly.api.service.workout.WorkoutService;
import it.coachly.api.service.workout.data.WorkoutDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/workouts")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;

    @GetMapping("/user/{userId}")
    public List<WorkoutDto> getAllUserWorkouts(@PathVariable UUID userId) {
        log.debug("Fetching all workouts for user: {}", userId);
        return this.workoutService.getAllUserWorkouts(userId);
    }

}
