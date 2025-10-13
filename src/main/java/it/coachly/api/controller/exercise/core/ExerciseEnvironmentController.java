package it.coachly.api.controller.exercise.core;

import it.coachly.api.service.exercise.component.core.ExerciseEnvironmentService;
import it.coachly.api.service.exercise.data.component.core.ExerciseEnvironmentDto;
import it.coachly.api.service.exercise.data.component.core.save.ExerciseEnvironmentSaveDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/exercises/environment")
@RequiredArgsConstructor
public class ExerciseEnvironmentController {
    private final ExerciseEnvironmentService exerciseEnvironmentService;

    @PatchMapping
    public ResponseEntity<UUID> save(@RequestBody @Valid ExerciseEnvironmentSaveDto dto) {
        return ResponseEntity.ok(exerciseEnvironmentService.save(dto));
    }

    @GetMapping("/{exerciseId}")
    public ResponseEntity<ExerciseEnvironmentDto> getByExercise(@PathVariable UUID exerciseId) {
        return ResponseEntity.ok(exerciseEnvironmentService.getExerciseEnvironment(exerciseId));
    }
}
