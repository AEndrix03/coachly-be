package it.coachly.api.controller.exercise;

import it.coachly.api.service.exercise.component.core.ExerciseMetricService;
import it.coachly.api.service.exercise.data.component.metrics.save.ExerciseMetricSaveDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/exercises/metric")
@RequiredArgsConstructor
public class ExerciseMetricController {
    private final ExerciseMetricService exerciseMetricService;

    @PatchMapping
    public ResponseEntity<UUID> save(@RequestBody @Valid ExerciseMetricSaveDto dto) {
        return ResponseEntity.ok(exerciseMetricService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        exerciseMetricService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

