package it.coachly.api.controller.exercise;

import it.coachly.api.service.exercise.ExerciseService;
import it.coachly.api.service.exercise.data.ExerciseDto;
import it.coachly.api.service.exercise.data.detail.ExerciseDetailDto;
import it.coachly.api.service.exercise.data.save.ExerciseSaveDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/exercises")
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseService exerciseService;

    @GetMapping
    public ResponseEntity<Page<ExerciseDto>> getPaginated(Pageable pageable) {
        return ResponseEntity.ok(exerciseService.getPaginated(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseDetailDto> getDetailById(@PathVariable UUID id) {
        return ResponseEntity.ok(exerciseService.getDetailById(id));
    }

    @PatchMapping
    public ResponseEntity<UUID> save(@RequestBody @Valid ExerciseSaveDto dto) {
        return ResponseEntity.ok(exerciseService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        exerciseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

