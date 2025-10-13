package it.coachly.api.controller.exercise.equipment;

import it.coachly.api.service.exercise.component.equipment.ExerciseEquipmentService;
import it.coachly.api.service.exercise.data.component.equipment.save.ExerciseEquipmentSaveDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/exercises/equipment")
@RequiredArgsConstructor
public class ExerciseEquipmentController {
    private final ExerciseEquipmentService exerciseEquipmentService;

    @PatchMapping
    public ResponseEntity<UUID> save(@RequestBody @Valid ExerciseEquipmentSaveDto dto) {
        return ResponseEntity.ok(exerciseEquipmentService.save(dto));
    }

    @PatchMapping("/all")
    public ResponseEntity<List<UUID>> saveAll(@RequestBody @Valid List<ExerciseEquipmentSaveDto> dtos) {
        return ResponseEntity.ok(exerciseEquipmentService.saveAll(dtos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        exerciseEquipmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
