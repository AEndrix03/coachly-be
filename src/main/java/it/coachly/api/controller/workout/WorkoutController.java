package it.coachly.api.controller.workout;

import it.coachly.api.service.user.UserRetriever;
import it.coachly.api.service.workout.WorkoutService;
import it.coachly.api.service.workout.data.WorkoutDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PostMapping()
    public UUID patchWorkout(@RequestBody WorkoutDto workoutDto) {
        log.debug("Patching workout with id: {}", workoutDto.getId());
        return this.workoutService.patchWorkout(workoutDto);
    }

    @DeleteMapping("/{workoutId}")
    public ResponseEntity<Void> deleteWorkout(@PathVariable UUID workoutId) {
        var user = this.userRetriever.retrieve();
        this.workoutService.deleteWorkout(user.getId(), workoutId);
        return ResponseEntity.noContent().build();
    }

}
