package it.coachly.api.controller.exercise.core;

import it.coachly.api.service.exercise.component.core.ExerciseMovementPatternService;
import it.coachly.api.service.exercise.data.component.core.ExerciseMovementPatternDto;
import it.coachly.api.service.exercise.data.component.core.save.ExerciseMovementPatternSaveDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/exercises/movement-pattern")
@RequiredArgsConstructor
public class ExerciseMovementPatternController {
    private final ExerciseMovementPatternService exerciseMovementPatternService;

    @GetMapping("/{exerciseId}")
    public ResponseEntity<ExerciseMovementPatternDto> getByExercise(@PathVariable UUID exerciseId) {
        return ResponseEntity.ok(exerciseMovementPatternService.getExerciseMovementPattern(exerciseId));
    }

    @PatchMapping
    public ResponseEntity<UUID> save(@RequestBody @Valid ExerciseMovementPatternSaveDto dto) {
        return ResponseEntity.ok(exerciseMovementPatternService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        exerciseMovementPatternService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
