package it.coachly.api.controller.exercise;

import it.coachly.api.service.exercise.component.core.ExerciseInstructionService;
import it.coachly.api.service.exercise.data.component.core.save.ExerciseInstructionSaveDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/exercises/instruction")
@RequiredArgsConstructor
public class ExerciseInstructionController {
    private final ExerciseInstructionService exerciseInstructionService;

    @PatchMapping
    public ResponseEntity<UUID> save(@RequestBody @Valid ExerciseInstructionSaveDto dto) {
        return ResponseEntity.ok(exerciseInstructionService.save(dto));
    }

    @PatchMapping("/all")
    public ResponseEntity<List<UUID>> saveAll(@RequestBody @Valid List<ExerciseInstructionSaveDto> dtos) {
        return ResponseEntity.ok(exerciseInstructionService.saveAll(dtos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        exerciseInstructionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
