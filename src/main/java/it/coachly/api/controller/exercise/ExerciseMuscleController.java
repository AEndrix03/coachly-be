package it.coachly.api.controller.exercise;

import it.coachly.api.service.exercise.component.muscle.ExerciseMuscleService;
import it.coachly.api.service.exercise.data.component.muscle.save.ExerciseMuscleSaveDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/exercises/muscle")
@RequiredArgsConstructor
public class ExerciseMuscleController {
    private final ExerciseMuscleService exerciseMuscleService;

    @PatchMapping
    public ResponseEntity<UUID> save(@RequestBody @Valid ExerciseMuscleSaveDto dto) {
        return ResponseEntity.ok(exerciseMuscleService.save(dto));
    }

    @PatchMapping("/all")
    public ResponseEntity<List<UUID>> saveAll(@RequestBody @Valid List<ExerciseMuscleSaveDto> dtos) {
        return ResponseEntity.ok(exerciseMuscleService.saveAll(dtos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        exerciseMuscleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
