package it.coachly.api.controller.exercise.safety;

import it.coachly.api.service.exercise.component.safety.ExerciseSafetyContraindicationService;
import it.coachly.api.service.exercise.data.component.safety.save.ExerciseSafetyContraindicationSaveDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/exercises/safety-contraindication")
@RequiredArgsConstructor
public class ExerciseSafetyContraindicationController {
    private final ExerciseSafetyContraindicationService exerciseSafetyContraindicationService;

    @PatchMapping
    public ResponseEntity<UUID> save(@RequestBody @Valid ExerciseSafetyContraindicationSaveDto dto) {
        return ResponseEntity.ok(exerciseSafetyContraindicationService.save(dto));
    }

    @PatchMapping("/batch")
    public ResponseEntity<List<UUID>> saveAll(@RequestBody @Valid List<ExerciseSafetyContraindicationSaveDto> dtos) {
        return ResponseEntity.ok(exerciseSafetyContraindicationService.saveAll(dtos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        exerciseSafetyContraindicationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

