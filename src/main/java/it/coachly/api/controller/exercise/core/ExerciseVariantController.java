package it.coachly.api.controller.exercise.core;

import it.coachly.api.service.exercise.component.core.ExerciseVariationService;
import it.coachly.api.service.exercise.data.component.core.save.ExerciseVariantSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/exercise/variant")
@RequiredArgsConstructor
public class ExerciseVariantController {
    private final ExerciseVariationService exerciseVariationService;

    @PostMapping
    public ResponseEntity<UUID> save(@RequestBody ExerciseVariantSaveDto dto) {
        UUID id = exerciseVariationService.save(dto);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        exerciseVariationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

