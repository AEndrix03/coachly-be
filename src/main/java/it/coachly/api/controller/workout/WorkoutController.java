package it.coachly.api.controller.workout;

import it.coachly.api.service.user.UserRetriever;
import it.coachly.api.service.workout.WorkoutService;
import it.coachly.api.service.workout.data.WorkoutDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/workouts")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;
    private final UserRetriever userRetriever;

    @GetMapping("/user")
    public List<WorkoutDto> getAllUserWorkouts() {
        var user = this.userRetriever.retrieve();
        log.debug("Fetching all workouts for user: {}", user.getId());
        return this.workoutService.getAllUserWorkouts(user.getId());
    }

}
