package it.coachly.api.controller.exercise.safety;

import it.coachly.api.service.exercise.component.safety.ExerciseSafetyService;
import it.coachly.api.service.exercise.data.component.safety.save.ExerciseSafetySaveDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/exercises/safety")
@RequiredArgsConstructor
public class ExerciseSafetyController {
    private final ExerciseSafetyService exerciseSafetyService;

    @PatchMapping
    public ResponseEntity<UUID> save(@RequestBody @Valid ExerciseSafetySaveDto dto) {
        return ResponseEntity.ok(exerciseSafetyService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        exerciseSafetyService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

